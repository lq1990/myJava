package com.mycp.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.mycp.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerUserApplicationTests {

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
        userService.hello();

    }

}
