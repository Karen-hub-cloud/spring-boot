package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class WindowsButton implements  Button {
    @Override
    public void paint() {
        System.out.println("你创建的是Windows Button");
    }
}
