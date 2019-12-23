package com.mycp.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 * 1. 导入数据库文件。创建出 department, employee 表
 * 2. 创建javaBean封装数据
 * 3. 整合Mybatis操作db
 *      3.1 配置数据源信息
 *      3.2 使用注解版的Mybatis
 *          1. @MapperScan指定需要扫描的mapper接口所在的包
 *
 *
 * 二、快速体验缓存
 *      步骤：
 *          1. 开启基于注解的缓存 @EnableCaching
 *          2. 标注缓存注解即可
 *              @Cacheable  @CacheEvict @CachePut
 *
 *      默认使用的是：ConcurrentMapCacheManager, ConcurrentMapCache；将数据保存在ConcurrentMap<Object,>
 *          开发中使用缓存中间件：redis, memcached, ehcache
 *
 * 三：整合redis作为缓存
 *
 *
 *
 */
@MapperScan("com.mycp.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01CacheApplication.class, args);
    }

}
