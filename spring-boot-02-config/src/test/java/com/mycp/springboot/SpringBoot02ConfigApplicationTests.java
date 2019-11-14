package com.mycp.springboot;

import com.mycp.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SB单元测试;
 * 可以在测试期间方便的类似编码一样进行自动注入 等容器的功能
 */
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;


    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
