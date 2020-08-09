package com.springbootexample.springbootdemo.review.Design_pattern.Factory;

public class textButton implements Button {
    @Override
    public void render() {
        System.out.println("textButton");
    }

    @Override
    public void onClick() {

        System.out.println("textOnclick");
    }
}
