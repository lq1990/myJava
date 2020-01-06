package com.mycp.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * boot 使用配置类 代替spring中的applicationContext.xml配置文件
 *
 * @author lq
 * create 2020-01-06 15:59
 */
@Configuration
public class ConfigBean {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}


/**
 * <bean id=""  class="" ></bean>
 * 被替代
 * @Bean
 * public xxx xxx() {
 *
 * }
 */
