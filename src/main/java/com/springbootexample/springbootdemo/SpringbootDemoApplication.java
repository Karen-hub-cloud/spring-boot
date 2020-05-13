package com.springbootexample.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/*
搭建Mybits环境
1.导入数据库文件，创建出department和employee表
2.创建javaBean操作数据库
3.整合MyBits操作数据库
    1.配置数据源信息（application.yml中）
    2.使用注解版的Mybits
        1>入口类中@MapperScan指定需要扫描的接口所在的包

快速体验
步骤：
    1.开启基于注解的缓存@EnableCaching
    2.标注缓存注解即可
        @Cachable
        @CachEvict
        @CachPut

整合redis作为缓存
    安装redis:使用docker
    引入依赖
    配置redis(application.yml)
    测试缓存
        原理：CacheManger == Cache 缓存组件来给缓存中CRUD数据
        1.引入redis的starter,容器中保存的是RedisCacheManager
        2.RedisCacheManager帮我们创建RedisCache作为缓存组件
        3.默认保存数据 k-v 都是object，利用序列化保存，如何自动保存为json?
            1.引入了redis的starter,cacheManger变为了RedisCacheManger
            2.默认创建的RedisCacheManger 操作redis的时候使用的是jdk的序列化机制
        4。所以我们自定义RedisCacheManger

 */
@EnableCaching
@MapperScan("com.springbootexample.springbootdemo.mapper")
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Bean
    public ViewResolver myViewResolver(){
        return  new MyViewResolver();
    }

    private static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
