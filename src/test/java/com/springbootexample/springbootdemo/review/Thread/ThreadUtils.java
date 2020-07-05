package com.springbootexample.springbootdemo.review.Thread;
//创建线程方式一：集成Thraed类，重写run(),调用start()
public class ThreadUtils extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){
            System.out.println("我在看代码-------"+i);
        }
    }
    public static void main(String args[]){
        //创建一个线程对象
        ThreadUtils threadUtils = new ThreadUtils();
        //调用start方法,开辟新的线程
        threadUtils.start();
        //普通方法
//        threadUtils.run();
        for(int i = 0; i < 1000 ;i++){
            System.out.println("我在学习多线程------"+i);
        }
    }
}
