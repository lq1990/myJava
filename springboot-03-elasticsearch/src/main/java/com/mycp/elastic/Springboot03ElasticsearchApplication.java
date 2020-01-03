package com.mycp.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SB默认支持两种技术和ES交互，
 * 1. Jest 默认不生效
 *      若想生效，需要导入依赖jest的工具包 io.searchbox.client.JestClient
 *      并将pom.xml中elasticsearch的依赖注释
 *      配置application.properties:
 *          spring.elasticsearch.jest.uris=http://39.105.96.93:9200/
 *
 *
 *
 * 2. SpringData ElasticSearch
 *     ES version有可能不合适: es版本要求6.8.5 （通过查看maven整合lib 可知，再docker下载此版本es。之前docker下载的是最新版本）
 *       方法1：升级SB版本
 *       方法2： 安装对应版本的ES...
 *
 *
 *      1. Client 节点信息clusterNodes clusterName
 *      2. ElasticsearchTemplate 操作es
 *      3. 编写一个ElasticsearchRepository的子接口来操作ES
 *
 *      两种用法：
 *      1. 编写一个 ElasticsearchRepository
 *      2.
 *
 */
@SpringBootApplication
public class Springboot03ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticsearchApplication.class, args);
    }

}
