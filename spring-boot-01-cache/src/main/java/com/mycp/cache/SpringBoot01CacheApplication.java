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
 *      默认使用的是：ConcurrentMapCacheManager, ConcurrentMapCache；
 *        将数据保存在ConcurrentMap<Object,>
 *          开发中使用缓存中间件：redis, memcached, ehcache
 *
 * 三：整合redis作为缓存
 *      redis: 分布式的内存数据库缓存
 *    1. 安装redis，使用docker安装
 *      $ docker images  查看docker镜像
 *      $ docker pull redis
 *      $ lsof -i:6379   查看哪些进程使用了6379port, $ kill -9 pid  关闭此进程
 *      $ docker run -d -p 6379:6379 --name myredis docker.io/redis   运行redis，-d 后台运行
 *      使用 Redis Desktop Manager 界面打开redis
 *
 *    2. 引入redis的 starter
 *    3. 配置redis
 *    4. 测试缓存
 *        原理：CacheManager === Cache 缓存组件来实际给缓存中存取数据
 *        4.1 引入 redis starter，容器中保存的是 RedisCacheManager;
 *        4.2 RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件。RedisCache通过操作redis缓存数据
 *        4.3 默认保存数据 k-v 都是Object；利用序列化保存。如何保存为json？
 *            1. 引入redis的starter，cacheManager变为RedisCacheManager
 *            2. 默认创建的RedisCacheManager 操作redis时使用的是 RedisTemplate<>
 *            3. RedisTemplate<Object, Object>是默认使用jdk的序列化机制
 *        4.4 自定义CacheManager
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
