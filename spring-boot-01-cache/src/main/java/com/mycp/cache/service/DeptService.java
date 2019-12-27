package com.mycp.cache.service;

import com.mycp.cache.bean.Department;
import com.mycp.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * create 2019-12-27 17:00
 */
@CacheConfig(cacheManager = "cacheManager")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("cacheManager") //指定
    @Autowired
    RedisCacheManager cacheManager;


    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门id："+id);
        Department dept = departmentMapper.getDeptById(id);

        
        // 当不用@Cacheable，而是手动添加缓存 即使用编码方式使用缓存
        // 获取缓存
//        Cache dept1 = cacheManager.getCache("dept");
//        dept1.put("dept:1", dept);

        return dept;
    }


}
