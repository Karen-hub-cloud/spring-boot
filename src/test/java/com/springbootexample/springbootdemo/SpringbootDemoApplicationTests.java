package com.springbootexample.springbootdemo;

import com.springbootexample.springbootdemo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * springboot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入容器的功能
 */
@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testHelloServeice(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }


}
