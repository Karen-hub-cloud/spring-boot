package com.springbootexample.springbootdemo.review.Design_pattern.Clone;

public class circle extends shape {
    public int radius;

    public circle(){

    }

    public circle(circle target){
        super(target);
        if(target != null){
            this.radius = target.radius;
        }
    }

    @Override
    public shape clone() {
        return new circle(this);
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof circle) || !super.equals(object))
            return false;
        circle shape = (circle) object;
        return shape.radius == radius;
    }
}
