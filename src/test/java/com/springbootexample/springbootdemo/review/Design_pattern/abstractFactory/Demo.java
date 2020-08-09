package com.springbootexample.springbootdemo.review.Design_pattern.abstractFactory;

public class Demo {
    private static Application configurelication(){
        Application application;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.equals("mac")){
            factory = new MacFactory();
            application = new Application(factory);
        }else {
            factory = new WindowsFactory();
            application = new Application(factory);
        }
        return application;
    }

    public static void main(String[] args) {
        Application application = configurelication();
        application.paint();
    }
}
