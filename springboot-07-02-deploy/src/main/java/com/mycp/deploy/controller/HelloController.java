package com.mycp.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lq
 * create 2020-01-04 20:48
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello() {
        return "hello2";
    }

}
