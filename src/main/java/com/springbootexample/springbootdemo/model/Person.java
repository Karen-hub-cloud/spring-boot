package com.springbootexample.springbootdemo.model;

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
public class Person {
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
    private Integer age;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
