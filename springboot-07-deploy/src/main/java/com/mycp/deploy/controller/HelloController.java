package com.mycp.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lq
 * create 2020-01-04 20:41
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }


}
