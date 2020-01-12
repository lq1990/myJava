package com.mycp.springcloud.dao;

import com.mycp.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 增删改查
 *
 * @author lq
 * create 2020-01-06 14:06
 */
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
