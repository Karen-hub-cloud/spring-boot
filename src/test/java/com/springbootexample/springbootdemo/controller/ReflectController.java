package com.springbootexample.springbootdemo.controller;

import com.springbootexample.springbootdemo.model.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/*
 * @Author Karen
 * @Description //TODO 9:52 * @Date 9:52 2020/6/25
 * @URL : https://www.bilibili.com/video/BV1Bs411u7e9
 * @Param Java反射机制
 * @return 
 **/
public class ReflectController {
    /*
     * 初识
     **/
    @Test
    public void test() throws Exception {
        Class clazz = Person.class;
        System.out.println(clazz);
        Person person = (Person) clazz.newInstance();
        //1.正常调用
        person.setAge(23);
        System.out.println(person);
        System.out.println(person.hello());
        System.out.println(person.hello("田坤"));

        //2.通过反射调用运行时指定的属性
        //public
        Field f1 = clazz.getField("age");
        f1.set(person,23);
        //private
        Field f2 = clazz.getDeclaredField("boss");
        f2.setAccessible(true);
        f2.set(person,true);
        System.out.println(person);

        //3.通过反射调用运行时指定的方法
        //public 无参
        Method method = clazz.getMethod("hello");
        System.out.println(method.invoke(person));
        //private 无参
        Method method1 = clazz.getDeclaredMethod("privateHello");
        method1.setAccessible(true);
        System.out.println(method1.invoke(person));
        //public 有参
        Method method2 = clazz.getMethod("hello",String.class);
        System.out.println(method2.invoke(person,"tk"));

    }
    /*
     * 源头：Class类
     * 我们创建了一个类，通过编译（javac.exe）生成了对应的.class文件
     * 使用java.exe加载.class文件（类加载器），加载到内存，就是一个运行时类，存放在缓存区
     * 这个运行时类本身就是一个Class的对象
     * note:每一个运行时类只加载一次
     *
    **/
    @Test
    public void test1(){
        //有一个运行时的对象
        Person person = new Person();
        //通过运行时的对像得到运行时类
        Class clazz = person.getClass();
        System.out.println(clazz);
    }
    /*
     * 获取Class类的四种方式
     * 了解类的加载器
     **/
    @Test
    public void test2() throws ClassNotFoundException {
        //1.通过运行时类直接获取
        Class clazz = Person.class;
        System.out.println(clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);

        //2.通过运行时对象获取
        Person person = new Person();
        Class clazz1 = person.getClass();
        System.out.println(clazz1);
        ClassLoader classLoader1 = clazz1.getClassLoader();
        System.out.println(classLoader1);

        //3.通过类路径加载
        String className = "com.springbootexample.springbootdemo.model.Person";
        Class clazz2 = Class.forName(className);
        System.out.println(clazz2);
        ClassLoader classLoader2 = clazz2.getClassLoader();
        System.out.println(classLoader2);

        //4.通过类加载器
        ClassLoader classLoader3 = this.getClass().getClassLoader();
        Class clazz3 = classLoader3.loadClass(className);
        System.out.println(clazz3);

        //说明只加载了一次
        System.out.println(clazz == clazz1);
        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);
        System.out.println(clazz2 == clazz3);
    }

    /*
     * 了解类的加载器
     **/
    @Test
    public void test3() throws IOException {

        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

        Person person = new Person();
        ClassLoader classLoader1 = person.getClass().getClassLoader();
        System.out.println(classLoader1);

        //系统类加载器
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader2);
        //扩展类加载器
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);
        //引导类加载器
        ClassLoader classLoader4 = classLoader3.getParent();
        System.out.println(classLoader4);

        //读文件，在同一个包中
//        ClassLoader classLoader5 = this.getClass().getClassLoader();
//        InputStream inputStream = classLoader5.getResourceAsStream("springboot-demo\\src\\test\\java\\com\\springbootexample\\springbootdemo\\controller\\tk.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);
//        System.out.println(properties.getProperty("name"));
//        System.out.println(properties.getProperty("password"));

    }

    /*
     * newInstance()调用无参的构造器：
     * 1.有无参的构造器  2.构造器的权限要足够
     **/
    @Test
    public void test4() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Person person = (Person) clazz.newInstance();
        person.setAge(23);
        System.out.println(person);
        Person person1 = new Person();
        System.out.println(person1);
        System.out.println(person == person1); //false
    }
    /*
     * 获取类的内部结构：属性
     **/
    @Test
    public void test5(){
        Class clazz = Person.class;
        //获取所有属性
        //1.getFields只能获取运行时类及其父类声明为public的属性
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            //1.1权限修饰符
            System.out.println(Modifier.toString(field.getModifiers()));
            //1.2变量类型
            System.out.println(field.getType());
            //1.3属性名
            System.out.println(field.getName());
            //1.4 注解
            System.out.println(field.getAnnotatedType());
        }
        //2.这个可以获取运行时类所有类型的属性
        Field[] fields1 = clazz.getDeclaredFields();
        for(Field field : fields1 ){
            System.out.println(field.getName());
        }
    }
    /*
     * 获取类的内部结构：方法
     * 注意返回的大多是数组
     **/
    @Test
    public void test6(){
        Class clazz = Person.class;
        //1.获取当前运行类、父类的方法，只能public
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        //2.获取运行时类所有的
        Method[] methods1 = clazz.getDeclaredMethods();
        for(Method method : methods1){
            System.out.println(method);
            //1.注解
            System.out.println(method.getDeclaredAnnotations());
            //异常类型
            System.out.println(method.getExceptionTypes());
            //方法名
            System.out.println(method.getName());
            //权限修饰符
            System.out.println(Modifier.toString(method.getModifiers()));
            //类型
            System.out.println(method.getReturnType());
            //形参列表
            Class[] paramter = method.getParameterTypes();
            for(Class p : paramter){
                System.out.println(p.getName());
                System.out.println(p.getTypeName());
            }

        }
    }
    /*
     *  获取类的内部结构：构造器
     **/
    @Test
    public void test7(){
        Class clazz = Person.class;
        Constructor[] constructors =clazz.getDeclaredConstructors();
        for (Constructor constructor: constructors){
            System.out.println(constructor.getName());
            System.out.println(Modifier.toString(constructor.getModifiers()));
        }
    }
    /*
     *  其他
     **/
    @Test
    public void test8(){
        Class clazz = Person.class;
        //获取父类
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);
        //获取带泛型的父类
        Type superClass1 = clazz.getGenericSuperclass();
        System.out.println(superClass1);
        //获取父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType) superClass1;
        Type[] ars = parameterizedType.getActualTypeArguments();
        System.out.println(ars[0].getTypeName());
        //获取实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces){
            System.out.println(i);
        }
        //获取所在的包
        Package p = clazz.getPackage();
        System.out.println(p);
        //获取注解
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for(Annotation annotation: annotations){
            System.out.println(annotation);
        }
    }
    /*
     * 通过反射调用类中指定的方法和属性
     **/
    @Test
    public void test9() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        //获取指定的属性
        Field name = clazz.getDeclaredField("lastname");
        name.setAccessible(true);
        //创建运行时类的对象
        Person person = (Person) clazz.newInstance();
        //将运行时类的指定属性赋值
        person.setLastname("tk");
        Field age = clazz.getField("age");
        age.set(person,10);
        System.out.println(person);
        //获取名为hello的方法
        Method methods = clazz.getDeclaredMethod("hello");
        System.out.println(methods.invoke(person));
        //调用指定的构造器
        Constructor constructor = clazz.getDeclaredConstructor();
        System.out.println(constructor);
    }


}
