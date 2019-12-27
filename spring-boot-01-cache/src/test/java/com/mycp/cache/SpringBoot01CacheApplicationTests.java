package com.mycp.cache;

import com.mycp.cache.bean.Employee;
import com.mycp.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

@SpringBootTest
class SpringBoot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; // k-v 都是字符串

    @Autowired
    RedisTemplate redisTemplate; // kv 都是对象

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    /**
     * String(字符串)、
     * List(列表)、
     * Set（集合）、
     * Hash（散列），
     * ZSet（有序集合）
     *
     */
    @Test
    public void test01() {
        // 用来操作五大类型的
        ValueOperations<String, String> str = stringRedisTemplate.opsForValue();
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        SetOperations<String, String> set = stringRedisTemplate.opsForSet();
        ZSetOperations<String, String> zset = stringRedisTemplate.opsForZSet();

//        str.set("msg", "hello from idea");
//        String msg = str.get("msg");
//        System.out.println(msg);

//        list.leftPush("mylist", "11");
//        list.leftPush("mylist", "12");

    }

    @Test
    public void test02() {

        ValueOperations str = employeeRedisTemplate.opsForValue();
        HashOperations hash = employeeRedisTemplate.opsForHash();
        SetOperations set = employeeRedisTemplate.opsForSet();
        ListOperations list = employeeRedisTemplate.opsForList();
        ZSetOperations zset = employeeRedisTemplate.opsForZSet();

        // 默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        Employee emp = employeeMapper.getEmpById(1);
        str.set("emp-01", emp);

        /**
         * 1. 将数据以json的方式保存
         *   1.1 自己将数据转为json
         *   1.2 redisTemplate默认的序列化规则；改变默认的序列化规则：见conf/MyRedisConf.java
         */



    }


    @Test
    void contextLoads() {

        Employee emp =
                employeeMapper.getEmpById(1);
        System.out.println(emp);

    }



}
