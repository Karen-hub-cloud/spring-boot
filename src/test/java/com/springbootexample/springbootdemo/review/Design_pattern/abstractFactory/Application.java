package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class Application {
    private Button button;
    private CheckBox checkBox;
    public Application(GUIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }
    public void paint(){
        button.paint();
        checkBox.paint();
    }
}
