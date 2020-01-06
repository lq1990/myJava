package com.mycp.springcloud.controller;

import com.mycp.springcloud.entities.Dept;
import com.mycp.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 返回json串，当使用注解 @RestController时
 *
 * @author lq
 * create 2020-01-06 14:44
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 注解@Requestbody ： 解析client发送过来的json数据，并封装到实体类中
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }




}
