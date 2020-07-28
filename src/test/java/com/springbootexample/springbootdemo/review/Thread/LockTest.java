package com.springbootexample.springbootdemo.review.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable{

    int tickNum = 10;

    //定义Lock锁🔒
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //加锁
                lock.lock();
                if(tickNum >0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNum -- );
                } else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}