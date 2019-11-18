package com.mycp.springboot;

import com.mycp.springboot.bean.Person;
import com.mycp.springboot.bean.Person2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SB单元测试;
 * 可以在测试期间方便的类似编码一样进行自动注入 等容器的功能
 */
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person2 person;

    /**
     * Spring容器
     */
    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean helloService = ioc.containsBean("helloService");

        System.out.println(helloService);
    }


    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
