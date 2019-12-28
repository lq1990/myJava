package com.mycp.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义MessageConverter，序列化 反序列化时数据转换类型
 *
 * @author lq
 * create 2019-12-28 20:11
 */
@Configuration
public class MyAMQPConfig {

    @Bean // 将元素添加到 spring容器中
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
