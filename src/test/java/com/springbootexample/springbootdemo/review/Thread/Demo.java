package com.springbootexample.springbootdemo.review.Thread;

public class Demo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }

    public static void main(String[] args) {
        //①继承Thread类
        Thread myThread = new MyThread();
        myThread.start();

        //②实现Runnable接口
        new Thread(new MyRunnable()).start();

        //③Java 8 函数式编程，可以省略MyThread类
        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}
