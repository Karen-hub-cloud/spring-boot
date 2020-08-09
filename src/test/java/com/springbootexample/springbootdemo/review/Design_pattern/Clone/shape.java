package com.springbootexample.springbootdemo.review.Design_pattern.Clone;

import java.util.Objects;

public abstract class shape {
    public int x;
    public int y;
    public String color;

    public shape(){

    }
    public shape(shape target){
        if(target != null){
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }
    public abstract shape clone();

    //重写equals方法
    @Override
    public boolean equals(Object o){
        if(!(o instanceof shape))
            return false;
        shape s = (shape)o;
        return s.x == x && s.y == y && Objects.equals(s.color,color);
    }
}
