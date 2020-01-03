package com.mycp.security.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lq
 * create 2020-01-03 16:04
 */
@Controller
public class KungfuController {

    private final String PREFIX="pages/";

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    /**
     * 登录页
     * @return
     */
    @GetMapping("/userlogin")
    public String loginPage() {
        return PREFIX+"login";
    }

    /**
     * level1 页面映射
     * @return
     */
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PREFIX+"level1/"+path;
    }

    /**
     * level2 页面映射
     * @return
     */
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX+"level2/"+path;
    }

    /**
     * level3 页面映射
     * @return
     */
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PREFIX+"level3/"+path;
    }





}
