package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class WindowscheckBox  implements CheckBox {
    @Override
    public void paint() {
        System.out.println("这是windows checkBox");
    }
}
