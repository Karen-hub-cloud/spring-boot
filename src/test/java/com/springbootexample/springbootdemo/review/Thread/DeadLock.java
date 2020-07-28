package com.springbootexample.springbootdemo.review.Thread;


import lombok.SneakyThrows;

public class DeadLock {
    public static void main(String[] args) {
        MakeUp makeUp = new MakeUp(0,"灰姑娘");
        MakeUp makeUp1 = new MakeUp(1,"白雪公主");

        makeUp.start();
        makeUp1.start();
    }
}

//口红
class Lipstick{

}
//镜子
class Mirror{

}

class MakeUp extends Thread{

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    MakeUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @SneakyThrows
    @Override
    public void run(){
       makeup();
    }

    private void makeup() throws InterruptedException{
        if(choice == 0){
            //获得口红的锁
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);

                //一秒钟后，获得镜子
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }else{
            //获得镜子的锁
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);

                //一秒钟后，获得口红
                synchronized (lipstick){
                    System.out.println(this.girlName+"获得口红的锁");
                }
            }
        }
    }
}
