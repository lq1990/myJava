package com.mycp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 本微服务的主启动类
 *
 * @author lq
 * create 2020-01-06 14:55
 */
@SpringBootApplication
@EnableEurekaClient  // 本服务启动后会自动注册进eureka服务中
public class DeptProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
