package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class MacButton implements  Button {
    @Override
    public void paint() {
        System.out.println("你创建了MacOs button");
    }
}
