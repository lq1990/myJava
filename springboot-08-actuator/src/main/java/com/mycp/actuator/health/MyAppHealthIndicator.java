package com.mycp.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lq
 * create 2020-01-05 11:26
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        // 自定义的检查方法
//        return Health.up().build(); // 代表健康

        return Health.down().withDetail("msg", "服务异常").build(); // down
    }
}
