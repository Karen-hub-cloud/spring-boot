package com.springbootexample.springbootdemo.review;

import com.springbootexample.springbootdemo.model.Person;
import org.junit.jupiter.api.Test;

public class Equals {
    @Test
    public void test(){
        /*Integer i1=40；Java 在编译的时候会直接将代码封装成 Integer i1=Integer.valueOf(40);，从而使用常量池中的对象。
        Integer i1 = new Integer(40);这种情况下会创建新的对象。*/
        int a = 1;
        int b = 1;
        //true 基本数据类型，只能用 == ，比较的是值
        System.out.println(a == b);
        //完全相等于int？
        Integer aa = 1;
        Integer dd = 1;
        //true 两个非New出来的Integet,如果再1-127之间，为true,否则为false,是直接从常量池里取得
        System.out.println(aa == dd);
        Integer bb = new Integer(1);
        Integer cc = new Integer(1);
        //false 对象， == 比较的是两个对象的地址是否相等
        System.out.println(bb == cc);
        //false 对象， == 比较的是两个对象的地址是否相等
        System.out.println(aa == bb);
        //true equals比较的是对象指向的值是否相等
        System.out.println(aa.equals(bb));
        //true 拆箱？
        System.out.println(a == aa);
        //true
        System.out.println(aa.equals(a));
        //true 自动拆箱
        System.out.println(a == bb);
        System.out.println(bb.equals(a));
    }
   /* Integer i1=40；Java 在编译的时候会直接将代码封装成 Integer i1=Integer.valueOf(40);从而使用常量池中的对象。
    Integer i1 = new Integer(40);这种情况下会创建新的对象。*/
    @Test
    public void test2(){
        Integer a = 40;
        Integer b = 40;
        //true
        System.out.println( a == b);
        Integer aa = new Integer(40);
        Integer bb = new Integer(40);
        //false
        System.out.println(aa == bb);
        //false
        System.out.println(a == aa);
    }

    @Test
    public void test1(){
        String a = "tk";
        String b = "tk";
        //a和b都是常量池中的数据，完全一样
        System.out.println(a == b);
        System.out.println(a.equals(b));
        //aa和bb都是对象，引用指向常量池
        String aa = new String("tk");
        String bb = new String("tk");
        //对象的地址不同
        System.out.println(aa == bb);
        //对象的值相同
        System.out.println(aa.equals(bb));
        //一个是常量池，一个是对象？
        System.out.println(a == aa);
        //比较值
        System.out.println(a.equals(aa));
    }
    @Test
    public void test3(){
        Person person = new Person();
        Person person1 = new Person();
        //false
        System.out.println(person == person1);
        //true
        System.out.println(person.equals(person1));
    }
}
