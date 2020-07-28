package com.springbootexample.springbootdemo.review.Thread;

//买票
//多个线程操作同一资源,会出现问题
public class ThreadUtils2 implements Runnable{

    private int ticketnum = 10;
    @Override
    public void run() {
        while (true){
            if(ticketnum <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----->拿到了第"+ticketnum+"张票");
            ticketnum -- ;
        }
    }

    public static void main(String[] args){
        ThreadUtils2 threadUtils2 = new ThreadUtils2();
        new Thread(threadUtils2,"小明").start();
        new Thread(threadUtils2,"tk").start();
        new Thread(threadUtils2,"拉拉").start();
    }
}
