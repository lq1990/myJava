package com.mycp.springcloud.service;

import com.mycp.springcloud.entities.Dept;

import java.util.List;

/**
 *
 *
 * @author lq
 * create 2020-01-06 14:38
 */
public interface DeptService {

    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();

}
