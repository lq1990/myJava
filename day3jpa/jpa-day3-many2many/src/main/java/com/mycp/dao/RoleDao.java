package com.mycp.dao;

import com.mycp.domain.Role;
import com.mycp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lq
 * create 2019-12-15 12:56
 */
public interface RoleDao
        extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {








}
