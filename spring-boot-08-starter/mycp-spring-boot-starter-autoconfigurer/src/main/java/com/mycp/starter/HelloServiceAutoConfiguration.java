package com.mycp.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lq
 * create 2019-12-19 12:01
 */
@EnableConfigurationProperties(HelloProperties.class)
@Configuration
@ConditionalOnWebApplication // web应用才生效
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    public HelloService helloService() {

        HelloService service = new HelloService();
        service.setHelloProperties(helloProperties);

        return service;
    }

}

















