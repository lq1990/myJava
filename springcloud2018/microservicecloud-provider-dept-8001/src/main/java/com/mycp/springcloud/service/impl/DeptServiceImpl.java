package com.mycp.springcloud.service.impl;

import com.mycp.springcloud.dao.DeptDao;
import com.mycp.springcloud.service.DeptService;
import com.mycp.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 方法名 get, list, post 更符合rest风格，所以使用。
 *
 * @author lq
 * create 2020-01-06 14:39
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }

}
