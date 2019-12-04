package com.mycp.dao;

import com.mycp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lq
 * create 2019-12-04 19:58
 */
public interface CustomerDao
        extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {




}
