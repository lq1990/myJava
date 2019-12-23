package com.mycp.cache.service;

import com.mycp.cache.bean.Employee;
import com.mycp.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * create 2019-12-19 16:46
 */
@CacheConfig(cacheNames="emp") // 抽取缓存配置的公共部分。 对该类进行注解配置，使得此类中的所有方法的注解都有这个
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法了。
     *
     * CacheManager: 管理多个Cache组件，对缓存的真正crud操作在Cache组件中，
     *      每个缓存组件都有自己的一个唯一的名字。
     *
     * 几个属性：
     *      cacheNames/value: 指定缓存的名字；
     *          数组的方式，可以指定多个缓存。
     *
     *      key：缓存数据使用的key；可以用他来指定。默认使用方法参数的值， 1-方法的返回值
     *          编写SpEL：#id 是参数id的值   #a0   #p0    #root.args[0]
     *          若想 getEmp[idx]获取缓存, key = "#root.methodName+'['+#id+']'"
     *
     *      keyGenerator: key的生成器；可以自己指定key的生成器的组件id
     *          key/keyGenerator：二选一使用
     *
     *      cacheManager: 指定缓存管理器；或者指定cacheResolver缓存解析器
     *      condition: 指定符合条件的情况下才缓存。condition = "#id>0"
     *      unless: 否定缓存；当unless指定的条件为true，
     *          方法的返回值就不会被缓存。可以获取到结果进行缓存。unless = "#result == null" 表示当result值为null时不缓存
     *      sync: 是否使用异步模式
     *
     * 原理：
     *  1. 自动配置类: CacheAutoConfiguration
     *  2. 缓存的配置类
     *  3. 哪个配置类默认生效：SimpleCacheConfiguration
     *  4. 给容器中注册了一个 CacheManager: ConcurrentMapCacheManager
     *  5. 可以获取和创建 ConcurrentMapCache类型的缓存组件；作用是：将数据保存在ConcurrentMap中
     *
     * 运行流程：
     * @Cacheable
     * 1. 方法运行之前，先去查询Cache缓存组件，按照cacheNames指定的名字获取
     *      (CacheManager先获取相应的缓存)，第一次获取缓存 若没有Cache组件会自动创建
     * 2. 去Cache中查找缓存的内容，使用一个key，默认是方法的参数
     *      key是按照某种策略生成的，默认是使用keyGenerator生成的key
     *          SimpleKeyGenerator 生成key的默认策略：
     *              如果没有参数：key = new SimpleKey();
     *              如果有一个参数：key=参数的值
     *              若有多个参数：key=new SimpleKey(params)
     *
     *
     * 3. 没有查到缓存，就调用目标方法；
     * 4. 将目标方法返回的结果，放进缓存中
     *
     * @Cacheable 标注的方法执行之前，先来检查缓存中有没有这个数据，
     *      默认按照参数的值作为key去查询缓存，
     *      如果没有就运行方法，并将结果放回缓存;
     *      以后再来调用就可以直接使用缓存中的数据；
     *
     * 核心：
     *  1. 使用CacheManager [ConcurrentMapCacheManager]按照名字得到Cache【ConcurrentMapCache】组件
     *  2. key使用keyGenerator生成的，默认是SimpleKeyGenerator
     *
     * @param id
     * @return
     */
    @Cacheable(/*cacheNames = {"emp"},*/ key = "#a0",
            condition = "#a0>0", unless = "#a0==200")
    public Employee getEmp(Integer id) {
        System.out.println("查询员工："+id);
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }


    /**
     * @CachePut 即调用方法，又更新缓存数据
     * 修改了数据库的某个数据，同时更新缓存；
     *
     * 区别于@Cacheable，运行时机不同：
     * @CachePut 1. 先调用目标方法，2. 将目标方法的结果缓存起来
     *
     *
     * 缓存使用的key: key="#employee.id" 使用传入的参数的员工id
     *              等价于：key="#result.id" 使用返回值的id
     *              注：@Cacheable 的key是不能用#result 的，因为@Cacheable先从缓存中取
     * @param emp
     * @return
     */
    @CachePut(
//            value = "emp",
            key = "#result.id")
    public Employee updateEmp(Employee emp) {
        System.out.println("updateEmp: "+emp);

        employeeMapper.updateEmp(emp);
        return emp;
    }

    /**
     * 测试步骤：
     * 1. 查询1号员工；查到的结果会放在缓存中
     * 2. 以后查询的还是之前的结果
     * 3. 更新1号员工
     *  4. 更新1号员工
     *
     *
     */


    /**
     * @CacheEvict：缓存清除
     *  key：指定要清除的数据
     *  allEntries=true: 指定清除这个缓存中所有的数据
     *  beforeInvocation=false: 缓存的清除是否在方法之前。默认是方法调用之后执行 缓存清除
     *      true：时，无论方法中是否有错误，缓存都会被删除
     */
    @CacheEvict(
//            value = "emp",
            key = "#id", beforeInvocation = true) // 缓存emp中放置很多k-v对
    public void deleteEmp(Integer id) {
        System.out.println("删除员工："+id);
//        employeeMapper.deleteEmp(id);
        int i=10/0;

    }


    /**
     * 因为有CachePut的原因，当使用lastName进行查询时，此方法会先被调用
     *
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(
//                            value = "emp",
                            key = "#lastName")
            },
            put = {
                    @CachePut(
//                            value = "emp",
                            key = "#result.id"), // 当id或email为null时 不能作为key，会报错
                    @CachePut(
//                            value = "emp",
                            key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        System.out.println(emp);
        return emp;
    }


}
