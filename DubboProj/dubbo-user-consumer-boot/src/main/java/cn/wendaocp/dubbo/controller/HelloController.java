package cn.wendaocp.dubbo.controller;

import cn.wendaocp.dubbo.bean.Order;
import cn.wendaocp.dubbo.bean.User;
import cn.wendaocp.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lq
 * create 2020-02-17 17:23
 */
@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public Object hello() {
        Order order = userService.buyNewMovie(new User(1, "anna"));

        return order;
    }


}
