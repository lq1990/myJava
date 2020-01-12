package com.mycp.springcloud.controller;

import com.mycp.springcloud.entities.Dept;
import com.mycp.springcloud.serivce.DeptClientService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 * @author lq
 * create 2020-01-06 16:11
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.deptClientService.get(id);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return this.deptClientService.list();
    }


    @RequestMapping("/consumer/dept/add")
    public Object add(Dept dept) {
        return this.deptClientService.add(dept);
    }

}
