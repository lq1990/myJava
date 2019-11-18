package com.mycp.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03LoggingApplicationTests {
    // 日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        // 日志级别，由低到高
        logger.trace("这是跟踪日志");
        logger.debug("这个debug信息");
        logger.info("这是info日志"); // SB默认设置info
        logger.warn("这是warn信息");
        logger.error("这是error信息");

    }

}
