package com.springbootexample.springbootdemo.review.Design_pattern.Factory;

public class WindowsDialog extends Diaglog {
    @Override
    public Button createButton() {
        System.out.println("这是windows dialog");
        return new textButton();
    }
}
