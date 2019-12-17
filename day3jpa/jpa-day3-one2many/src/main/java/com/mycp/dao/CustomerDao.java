package com.mycp.dao;

import com.mycp.domain.Customer;
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





}














