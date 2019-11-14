package com.mycp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ResponseBody使得这个类的所有方法返回的数据直接写给浏览器
 *  若return 对象 则可以转为json格式
 *
 * RestController 包含ResponseBody, Controller
 *
 * @author lq
 * create 2019-11-14 16:46
 */
//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world quick!";
    }

    // restapi

}
