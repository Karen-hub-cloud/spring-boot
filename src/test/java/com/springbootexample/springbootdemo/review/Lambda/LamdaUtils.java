package com.springbootexample.springbootdemo.review.Lambda;

public class LamdaUtils {

//    静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
//        1.外部类
        ILike like = new Like();
        like.lambda();
//       2.静态内部类
        like = new Like2();
        like.lambda();

//        3.局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

//        4.匿名内部类,没有类的名称，必须借助接口或父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I Like Lambda4");
            }
        };
        like.lambda();
//        5.Lambda表达式
        like = ()->{
            System.out.println("I Like Lambda5");
        };
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}
//1.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
