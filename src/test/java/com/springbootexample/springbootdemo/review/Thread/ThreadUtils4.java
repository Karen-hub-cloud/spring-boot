package com.springbootexample.springbootdemo.review.Thread;

//静态代理模式：真实对象和代理对象都要实现同一个接口，代理对象要代理真实角色，
//好处，代理对象可以做好多真实对象做不了的事情，真实对象专注做自己的事情
//例如：代理一些常用的处理
public class ThreadUtils4 {

    public static void main(String[] args) {
        //把真实对象给代理
//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
//        创建一个新线程？
        new Thread(()-> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}
//结婚接口
interface Marry{
    void HappyMarry();
}
//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了，超开心");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    //目标对象，真实对象
    private Marry target;

    //代理的构造器
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，婚庆公司收尾款");
    }

    private void before() {
        System.out.println("结婚之前，婚庆公司布置现场");
    }
}