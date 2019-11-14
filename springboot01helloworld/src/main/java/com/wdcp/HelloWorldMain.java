package com.wdcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 注解：用来标注一个主程序类，说明这是一个SB应用
 * @author lq
 * create 2019-11-14 11:09
 */
@SpringBootApplication
public class HelloWorldMain {
    public static void main(String[] args) {

        // Spring应用启动起来
        SpringApplication.run(HelloWorldMain.class, args);

    }

}

