package com.mycp.springcloud.controller;

import com.mycp.springcloud.entities.Dept;
import com.mycp.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 返回json串，当使用注解 @RestController时。
 *
 * 一旦调用服务方法失败并抛出了错误信息后，
 * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
 *
 * @author lq
 * create 2020-01-06 14:44
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.deptService.get(id);

        if (null == dept) {
            throw new RuntimeException("该id: "+id +" 没有对应的信息");
            // 一旦抛异常，会由 注解中配置的fallbackMethod处理
        }

        return dept;

    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("该id: "+id +" 没有对应的信息, null--@HystrixCommand")
                .setDb_source("no this database in Mysql");

        // 这样，前端工程师看到了，可以用特殊页面展示
    }


}
