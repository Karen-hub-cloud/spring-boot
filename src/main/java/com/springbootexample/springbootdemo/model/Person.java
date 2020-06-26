package com.springbootexample.springbootdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties:与配置文件的内容绑定
 * 只有这个组件时容器中的组件，才能使用这个注解
 */
@Component
@Validated
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:Person.properties"})
@Data
@MyAnnotation(value = "abc123")
public class Person extends Creature<String> implements Comparable,MyInterface{
    /**
     * <bean>
     *     <property name="lastName" value="字面量/${key}从环境变量，配置文件中取值/#{SpEl}"></property>
     * </bean>
     */
    /**
     * @Value不如@ConfigurationProperties(prefix = "person")方便
     */
    //@Value("${person.lastname}")
    private String lastname;
    //@Value("#{11*2}")
    public Integer age;
    //@Value("true")
    private Boolean boss;
    //@Email  配合@ConfigurationProperties才能用
    private Date birth;
    //@Value("person.maps.k1") 不支持
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
    public String hello(){
        return "hello";
    }
    public String hello(String name) throws Exception{
        return "hello:"+name;
    }
    private String privateHello(){
        return "private,hello";
    }
    //内部类
    class Bird{

    }

    public Person(String lastname, Integer age, Boolean boss, Date birth, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.lastname = lastname;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public Person() {
        super();
        System.out.println("调用无参的构造器");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
