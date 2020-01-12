package com.mycp.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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

    /**
     * 使用一个注解，既可以开启负载均衡，很方便
     * @return
     */
    @Bean
    @LoadBalanced // 开启负载均衡，Ribbon
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 定义LB即负载均衡规则.
     *
     * 用我们重新选择的随机算法替代默认的。
     *
     * @return
     */
    @Bean
    public IRule myRule() {
//        return new RoundRobinRule();
//        return new RandomRule();
        return new RetryRule();

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
