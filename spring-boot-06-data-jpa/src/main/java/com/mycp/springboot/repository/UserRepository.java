package com.mycp.springboot.repository;

import com.mycp.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lq
 * create 2019-12-18 14:38
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {




}
