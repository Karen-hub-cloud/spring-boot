package com.springbootexample.springbootdemo.review.Design_pattern.Factory;

public class HtmlDialog extends Diaglog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
