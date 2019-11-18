package com.wdcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lq
 * create 2019-11-14 11:14
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "Hello World!"; // the returned string is to be shown in browser directly.
    }

}
