package com.mycp.dao;

import com.mycp.domain.Customer;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 符合spring data jpa接口规范需要继承两个接口
 *  JpaRepository<操作的实体类类型，实体类中主键属性的类型>
 *      封装了基本crud操作
 *
 *  JpaSpecificationExecutor<操作的实体类类型>
 *      封装了复杂查询（比如分页）
 *
 * @author lq
 * create 2019-11-29 18:19
 */
public interface CustomerDao
        extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {


    /**
     * 案例：根据客户名称查客户。
     *  使用jpql的形式查询
     *  jpql: from Customer where custName=?
     *
     *  配置jpql语句：使用@Query
     *
     */
    @Query(value = "from Customer where custName = ?")
    public Customer findJpql(String custName);


    /**
     * 对于多个占位符，占位符位置 需要 一致于 方法参数位置（默认）
     *
     * 可以指定占位符参数的位置
     *  ? 索引的方式，指定此占位的取值来源
     *
     *
     * @param id
     * @param name
     * @return
     */
    @Query(value = "from Customer where custName=?2 and custId=?1")
    public Customer findCustNameAndId(Long id, String name);


    /**
     * 使用jpql 完成更新操作
     *  案例：根据id更新，客户的名称
     *
     *  sql:  update cst_customer set cust_name=? where cust_id=?
     *  jpql: update Customer set custName=? where custId=?
     *
     *  Query注解：代表的是进行查询
     *  若要进行更新操作，需要使用 @Modifying 表示当前执行的是一个更新操作
     *
     *
     */
    @Query(value = "update Customer set custName=?2 where custId=?1")
    @Modifying
    public void updateCustomer(Long id, String name);


    /**
     * 使用sql的形式查询
     *
     *  案例：查询全部
     *  sql: select * from cst_customer;
     *
     *  注解Query的参数：
     *      nativeQuery：true（使用sql），默认false（使用jpql）
     *
     */
    @Query(value = "select * from cst_customer", nativeQuery = true)
    public List<Object[]> findSql();


    @Query(value = "select * from cst_customer where cust_name like ?1", nativeQuery = true)
    public List<Object[]> findSql(String name);


    /**
     * 方法名的约定：
     * findBy 开头：查询
     *  对象中的属性名（首字母大写；查询的条件）
     *
     * findByCustName() 根据实体类中的某个属性进行查询
     *      在spring data jpa的运行阶段，会根据方法名称进行解析，
     *      findBy  =>  from Clz
     *      属性名称 => where custName =
     *
     */
    public Customer findByCustName(String name);


    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    public List<Customer> findByCustNameLike(String name);

    public List<Customer> findByCustNameLikeAndCustIndustryLike(String name, String industry);


}














