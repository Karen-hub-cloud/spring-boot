package com.springbootexample.springbootdemo.review.Thread;
//龟兔赛跑
public class ThreadUtils3 implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子") && i%10 == 0){
                try {
                    Thread.sleep(3);
                    System.out.println("兔子睡觉啦！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            //比赛结束，停止调用线程
            if(flag){
                break;
            }
            //打印步数
            System.out.println(Thread.currentThread().getName()+"----》跑了"+i+"步");
        }
    }
    private boolean gameOver(int steps){
        if(winner != null){
            return true;
        }else if(steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadUtils3 threadUtils3 = new ThreadUtils3();
        new Thread(threadUtils3,"兔子").start();
        new Thread(threadUtils3,"乌龟").start();

    }
}
