package com.mycp.springboot.controller;

import com.mycp.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebResult;
import java.util.Arrays;
import java.util.Map;

/**
 * @author lq
 * create 2019-11-19 10:02
 */
@Controller
public class HelloController {

//    @RequestMapping({"/", "/index.html"})
//    public String index() {
//
//        return "login"; // templates/login.html
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw  new UserNotExistException();
        }
        return "hello world!";
    }


    // 查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));

        // classpath:/templates/success.html
        return "success";
    }


}
