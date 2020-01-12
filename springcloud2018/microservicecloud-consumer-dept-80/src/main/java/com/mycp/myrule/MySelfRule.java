package com.mycp.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意：自定义的负载均衡规则，用此类做
 * 但此类不能和主启动类同包或子包下。因此才在新包下创建了此类
 *
 * @author lq
 * create 2020-01-08 10:20
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
//        return new RandomRule();
        return new RandomRule_LQ();
    }

}
