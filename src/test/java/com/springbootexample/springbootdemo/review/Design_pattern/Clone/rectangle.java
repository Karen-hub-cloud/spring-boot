package com.springbootexample.springbootdemo.review.Design_pattern.Clone;

public class rectangle extends shape {
    public int width;
    public int height;

    public rectangle() {
    }

    public rectangle(rectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public shape clone() {
        return new rectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof rectangle) || !super.equals(object2)) return false;
        rectangle shape2 = (rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }
}
