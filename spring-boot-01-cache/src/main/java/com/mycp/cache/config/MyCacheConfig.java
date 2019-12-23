package com.mycp.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lq
 * create 2019-12-20 11:51
 */
@Configuration
public class MyCacheConfig {

    /**
     * 自定义key的生成方式
     *
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {

                return method.getName()+"["+ Arrays.asList(params).toString()+"]";
            }
        };
    }


}

