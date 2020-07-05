package com.springbootexample.springbootdemo.review;

import com.springbootexample.springbootdemo.model.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/*
 * @Author Karen
 * @Description //TODO 10:07 * @Date 10:07 2020/6/30
 * @Param
 * @return
 **/
public class CallByValueUtils {
//    a:person1
//    b:person
//    Person:person1
//    Person1:person
    @Test
    public void callByVlaue(){
        Person person = new Person();
        person.setLastname("person");
        Person person1 = new Person();
        person1.setLastname("person1");
        swap(person,person1);
        System.out.println("Person:"+person.getLastname());
        System.out.println("Person1:"+person1.getLastname());
    }
    public void  swap(Person a,Person b){
//        Person c = a;
//        a = b;
//        b = c;
        String c = a.getLastname();
        a.setLastname(b.getLastname());
        b.setLastname(c);
        System.out.println("a:"+a.getLastname());
        System.out.println("b:"+b.getLastname());
    }
//    a:2
////    b:1
////    a:1
////    b:2
    @Test
    public void callByVlaue2(){
       int a = 1;
       int b =2;
       swap(a,b);
       System.out.println("a:"+a);
       System.out.println("b:"+b);
    }
    public void swap(int a,int b){
        int c = a;
        a = b;
        b= c;
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
//    a:2
//    b:1
//    a:1
//    b:2
    @Test
    public void callByVlaue3(){
        String a = "1";
        String b = "2";
        swap(a,b);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
    public void swap(String a,String b){
        String c = a;
        a = b;
        b = c;
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }

    @Test
    public void callByVlaue4(){
        int[] arrayList = new int[]{1, 2, 3};
        add(arrayList);
        System.out.println(arrayList[0]);
    }
    public void add(int[] a){
        a[0] = 0;
    }
}
