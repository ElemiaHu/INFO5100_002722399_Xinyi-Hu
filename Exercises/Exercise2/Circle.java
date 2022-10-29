package com.example.Exercise2;

public class Circle extends Shape{
    public static String name = "Circle";
    private double radius;
    private static final double PI = 3.14159;

    Circle () {
        super();
    }

    Circle (double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double calculateArea () {
        return PI * radius * radius / 4;
    }

    @Override
    public double calculatePerimeter () {
        return PI * radius;
    }
}
