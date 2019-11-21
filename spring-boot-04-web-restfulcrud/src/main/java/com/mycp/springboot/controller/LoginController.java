package com.mycp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lq
 * create 2019-11-20 13:46
 */
@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser", username);

            // 登录成功，防止表单重复提交，重定向到主页
            return "redirect:/main.html"; // templates/xxx.html
        } else {
            map.put("msg", "用户名或密码错误");

            return "login"; // templates/login.html
        }

    }
}
