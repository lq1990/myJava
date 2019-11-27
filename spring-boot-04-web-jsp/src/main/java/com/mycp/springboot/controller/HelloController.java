package com.mycp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lq
 * create 2019-11-24 14:58
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String success(Model model) {
        model.addAttribute("msg", "信息");
        return "success";
    }

}
