package com.mycp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * consumer想要使用provider的功能，
 * 1. 引入依赖
 * 2. 配置dubbo的注册中心地址
 * 3. 引用服务
 *
 */
@SpringBootApplication
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }

}
