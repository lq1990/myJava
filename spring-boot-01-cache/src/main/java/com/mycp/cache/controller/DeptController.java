package com.mycp.cache.controller;

import com.mycp.cache.bean.Department;
import com.mycp.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lq
 * create 2019-12-27 17:05
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;


    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return deptService.getDeptById(id);
    }

}
