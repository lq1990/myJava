package cn.wendaocp.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot整合Dubbo的步骤：
 * 1. 引入dubbo的starter
 * 2. dubbo相关的场景自动配好了
 *    1）以前配置还得配一遍
 *    application.properties中配置
 *
 * 3.
 *
 */
@EnableDubbo
@SpringBootApplication
public class DubboMovieProviderBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboMovieProviderBootApplication.class, args);
    }

}
