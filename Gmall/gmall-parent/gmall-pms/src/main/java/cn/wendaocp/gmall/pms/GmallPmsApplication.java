package cn.wendaocp.gmall.pms;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 配置整合dubbo
 * 2. 配置整合MyBatisPlus
 *
 * Logstash整合
 * 1. 导入依赖 logstash-logback-encoder
 * 2. 导日志配置 logback-spring.xml
 * 3. 在Kibana建立好日志的索引，就可以可视化检索
 *
 */
@EnableDubbo
@MapperScan(basePackages = "cn.wendaocp.gmall.pms.mapper")
@SpringBootApplication
public class GmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallPmsApplication.class, args);
    }
}
