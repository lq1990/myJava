package com.mycp.springboot.controller;

import com.mycp.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lq
 * create 2019-12-19 12:16
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        String wendao = helloService.sayHello("wendao");
        return wendao;
    }


}
