package com.mycp.task.controller;

import com.mycp.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lq
 * create 2020-01-03 11:43
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello();

        return "success";
    }





}
