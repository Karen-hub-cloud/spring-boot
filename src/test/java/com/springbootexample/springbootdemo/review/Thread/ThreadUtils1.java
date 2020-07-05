package com.springbootexample.springbootdemo.review.Thread;


//实现Runnable接口，重写run方法，创建Thread代理
public class ThreadUtils1 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("我在学习-----"+i);
        }
    }
    public static void main(String args[]){
        //创建一个线程对象
        ThreadUtils threadUtils = new ThreadUtils();
        //代理
        Thread thread = new Thread(threadUtils);
        //调用start方法,开辟新的线程
        thread.start();
        //普通方法
//        threadUtils.run();
        for(int i = 0; i < 1000 ;i++){
            System.out.println("我在学习多线程------"+i);
        }
    }
}
