package com.mycp.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置：
 *  1. RabbitAutoConfiguration
 *  2. 自动配置了连接工厂 CachingConnectionFactory
 *  3. RabbitProperties 封装了RabbitMQ 的配置
 *  4. RabbitTemplate：给RabbitMQ发送和接收消息
 *  5. AmqpAdmin: RabbitMQ 系统管理功能组件
 *  6. 主app类添加@EnableRabbit, Service类中方法加@RabbitListener
 *
 *
 */
@EnableRabbit // 开启基于注解的RabbitMQ
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
