package com.mycp.springboot.config;

import com.mycp.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解指明：当前类是一个配置类。替代以前用的配置文件
 *  以前，在配置文件中用 <bean></bean>标签添加组件
 *  如今：@Bean
 *
 * @author lq
 * create 2019-11-16 13:26
 */
@Configuration
public class MyAppConfig {

    /**
     * 将方法的返回值添加到容器中；容器中这个组件默认的 id就是方法名
     *
     * @return
     */
    @Bean
    public HelloService helloService() {
        System.out.println("MyAppConfig.helloService() 添加组件");

        return new HelloService();
    }
}

