package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class MacFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MaccheckBox();
    }
}
