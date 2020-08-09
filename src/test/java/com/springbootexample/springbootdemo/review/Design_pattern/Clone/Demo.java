package com.springbootexample.springbootdemo.review.Design_pattern.Clone;

import java.util.ArrayList;
import java.util.List;
public class Demo {
    public static void main(String[] args) {
        List<shape> shapes = new ArrayList<>();
        List<shape> shapesCopy = new ArrayList<>();

        circle circle = new circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        circle anotherCircle = (circle) circle.clone();
        shapes.add(anotherCircle);

        rectangle rectangle = new rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<shape> shapes, List<shape> shapesCopy) {
        for (shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
