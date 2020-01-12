package com.mycp.springcloud.controller;

import com.mycp.springcloud.entities.Dept;
import com.mycp.springcloud.service.DeptService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    /*
    * 服务发现， cloud.
    * 对于provider而言，希望被consumer发现
    *
    * */
    @Autowired
    private DiscoveryClient discoveryClient;

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


    @GetMapping("/dept/discovery")
    public Object discovery() {

        // 盘点eureka的所有微服务
        List<String> list = discoveryClient.getServices();
        System.out.println("********"+list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance elem : srvList) {
            System.out.println(elem.getServiceId()+"\t"+elem.getHost()+"\t"+
                    elem.getPort()+"\t"+elem.getUri());
        }
        return this.discoveryClient;

    }

}
