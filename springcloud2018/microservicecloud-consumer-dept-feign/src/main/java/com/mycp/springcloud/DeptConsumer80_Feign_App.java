package com.mycp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 在启动该微服务时，就去加载我们自定义Ribbon配置类，从而使配置生效
 *
 * @author lq
 * create 2020-01-06 16:57
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.mycp.springcloud"})
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }

}
