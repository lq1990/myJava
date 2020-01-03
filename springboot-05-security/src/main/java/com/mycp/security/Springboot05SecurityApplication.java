package com.mycp.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 引入 Spring Security
 * 2. 编写SpringSecurity的配置类
 *      MySecurityConfig，
 *          添加注解 @EnableWebSecurity extends WebSecurityConfigurerAdapter
 * 3. 控制请求的访问权限。
 *
 */
@SpringBootApplication
public class Springboot05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05SecurityApplication.class, args);
    }

}
