package com.mycp.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义健康状态指示器：
 * 1. 编写一个指示器，实现 HealthIndicator
 * 2. 指示器的名字 xxxHealthIndicator
 * 3. 加入容器中
 *
 */
@SpringBootApplication
public class Springboot08ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08ActuatorApplication.class, args);
    }

}
