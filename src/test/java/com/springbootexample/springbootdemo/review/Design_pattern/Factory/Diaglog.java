package com.springbootexample.springbootdemo.review.Design_pattern.Factory;

public abstract class Diaglog {
    public void renderWindow(){
        Button okButton = createButton();
        System.out.println("基础业务");
        okButton.render();
    }
    //返回的类型必须与抽象产品相同
    //创建者的工厂方法，会写一些基础业务
    public abstract Button createButton();
}
