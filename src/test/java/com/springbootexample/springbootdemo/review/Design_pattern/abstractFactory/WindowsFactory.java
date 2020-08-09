package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class WindowsFactory implements  GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowscheckBox();
    }
}
