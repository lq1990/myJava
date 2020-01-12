package com.mycp.springcloud.controller;

import com.mycp.springcloud.entities.Dept;
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

    /**
     * 使得consumer访问provider的地址
     */
//    private static final String Rest_URL_PREFIX="http://localhost:8001";
    private static final String Rest_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";


    /**
     * RestTemplate帮我们方便的 访问远程http服务。
     *
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        String url = Rest_URL_PREFIX + "/dept/add";
        Object req = dept;
        // 第三个参是 返回值类型
        return restTemplate.postForObject(url, req, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {

        return restTemplate.getForObject(Rest_URL_PREFIX+"/dept/get/"+id,
                Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(Rest_URL_PREFIX+"/dept/list",
                List.class);
    }

    /**
     * consumer用 /consumer/dept/discovery
     * 访问
     * provider的  /dept/discovery
     * @return
     */
    @RequestMapping("/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate
                .getForObject(Rest_URL_PREFIX+"/dept/discovery",
                Object.class);
    }

}
