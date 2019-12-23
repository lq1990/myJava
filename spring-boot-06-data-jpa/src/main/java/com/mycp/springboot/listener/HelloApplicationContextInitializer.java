package com.mycp.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lq
 * create 2019-12-18 17:53
 */
public class HelloApplicationContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        System.out.println("HelloApplicationContextInitializer.initialize(): "+ctx);
    }


}
