package com.mycp.ticket;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 将服务提供者注册到注册中心
 *      1. 引入dubbo和zkclient相关依赖
 *      2. 配置dubbo的扫描包和注册中心地址，在properties中配置
 *      3. 使用@Service 发布服务
 *
 */
@EnableDubbo
@SpringBootApplication
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}
