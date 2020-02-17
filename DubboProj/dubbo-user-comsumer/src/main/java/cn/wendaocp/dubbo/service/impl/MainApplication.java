package cn.wendaocp.dubbo.service.impl;

import cn.wendaocp.dubbo.bean.Order;
import cn.wendaocp.dubbo.bean.User;
import cn.wendaocp.dubbo.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * consumer
 *
 * @author lq
 * create 2020-02-16 18:53
 */
public class MainApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("consumer.xml");

        ctx.start();

        System.out.println("consumer, 测试远程调用。。。");

        UserService userService = ctx.getBean(UserService.class);
        Order order = userService.buyNewMovie(new User(1, "张三")); // test

        System.in.read();

    }
}
