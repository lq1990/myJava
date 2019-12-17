package com.mycp.dao;

import com.mycp.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lq
 * create 2019-12-14 10:05
 */
public interface LinkManDao
        extends JpaRepository<LinkMan, Long>, JpaSpecificationExecutor<LinkMan> {




}
