package com.springbootexample.springbootdemo.review.Thread;


import java.util.concurrent.CopyOnWriteArrayList;

public class JUCTest {
    public static void main(String[] args) {
        //这个类本身是安全的，当然也可以使用Synchronized来实现
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
