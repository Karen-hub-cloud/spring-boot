package com.springbootexample.springbootdemo.model;

public class Creature<T> {
    double weight;
    public void breath(){
        System.out.println("呼吸！");
    }
}
