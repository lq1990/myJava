package com.mycp.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync // 开启异步 注解功能
@EnableScheduling // 开启 任务
@SpringBootApplication
public class Springboot04TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04TaskApplication.class, args);
    }

}
