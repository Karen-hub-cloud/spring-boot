package com.springbootexample.springbootdemo.review.Design_pattern.Factory;

public class Demo {
    private static Diaglog diaglog;
    public static void main(String[] args){
        configure();
        runBusinessLogic();
    }
    static void configure(){
        if(System.getProperty("os.name").equals("Windows 10")){
            diaglog = new WindowsDialog();
        }else{
            diaglog = new HtmlDialog();
        }
    }
    static void runBusinessLogic(){
        diaglog.renderWindow();
    }
}
