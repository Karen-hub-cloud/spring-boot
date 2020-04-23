package com.springbootexample.springbootdemo.config;


import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是一个配置类，用来替代之前的配置文件
 * <bean></bean>
 */
@Configuration
public class Myconfig {
    //将方法的返回值添加到组件中，容器中组件的默认的id就是方法名
//    @Bean
//    public HelloService helloService(){
//        System.out.println("配置类@Bean给容器中加组件了");
//        return new HelloService();
//    }
}
