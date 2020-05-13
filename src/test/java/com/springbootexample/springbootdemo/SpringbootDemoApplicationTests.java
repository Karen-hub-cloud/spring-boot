package com.springbootexample.springbootdemo;

import com.springbootexample.springbootdemo.entities.Em;
import com.springbootexample.springbootdemo.mapper.EmployeeMapper;
import com.springbootexample.springbootdemo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * springboot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入容器的功能
 */
@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    Person person;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ApplicationContext ioc;

    //操作k-v都是字符串的，简化操作
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //k-v都是对象的
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,Object> myredisTemplate;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testHelloServeice(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextTest(){
        Em em = employeeMapper.getEmployeeById(1);
        System.out.println(em);
    }

    /*
    Redis五大数据类型
    String，List，set,hash,ZSet
    stringRedisTemplate.opsForValue()：字符串
    stringRedisTemplate.opsForList():操作list
    ...
     */
    @Test
    public void test01(){
        //给redis中保存一个数据
        stringRedisTemplate.opsForValue().append("msg","hello");
    }
    @Test
    public void test02(){
        //给redis中保存一个数据
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }
    @Test
    public void test03(){
        //给redis中保存一个数据
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        stringRedisTemplate.opsForList().leftPush("mylist","3");
        stringRedisTemplate.opsForList().leftPush("mylist","4");
    }

    @Test
    public void test04(){
        //append是追加字符串，存对象，我们用set
        //这里的Em类必须序列化
        Em emp = employeeMapper.getEmployeeById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("emp-01",emp);
        /*
        将数据以json的方式转存
            1》自己用工具，将对象转json
            2》redisTemplate默认的序列化规则
         */
        myredisTemplate.opsForValue().set("emp-02",emp);
    }



}
