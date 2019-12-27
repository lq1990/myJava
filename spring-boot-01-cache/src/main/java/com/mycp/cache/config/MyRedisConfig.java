package com.mycp.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycp.cache.bean.Employee;
import com.mycp.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * 自定义 redisTemplate
 * @author lq
 * create 2019-12-27 13:58
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) throws UnknownHostException {

        RedisTemplate<Object, Employee> template =
                new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);

        // 使用序列化器
        Jackson2JsonRedisSerializer<Employee> ser =
                new Jackson2JsonRedisSerializer(Employee.class);
        template.setDefaultSerializer(ser);

        return template;
    }

    /**
     * 自定义 RedisCacheManager
     * @param factory
     * @return
     */
    @Bean
    @Primary // 将某个cacheManager设置默认的
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration cacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofDays(1))   // 设置缓存过期时间为一天
                        .disableCachingNullValues()     // 禁用缓存空值，不缓存null校验
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new
                                GenericJackson2JsonRedisSerializer()));     // 设置CacheManager的值序列化方式为json序列化，可加入@Class属性
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();
    }


}
