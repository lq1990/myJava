package cn.wendaocp.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboUserConsumerBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboUserConsumerBootApplication.class, args);
    }

}
