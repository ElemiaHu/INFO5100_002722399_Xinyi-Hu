package com.example.Exercise2;

public class Rectangle extends Shape{
    public static String name = "Rectangle";
    private double height;
    private double width;

    Rectangle () {
        super();
    }

    Rectangle (double height, double width) {
        super();
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea () {
        return height * width;
    }

    @Override
    public double calculatePerimeter () {
        return 2 * (height + width);
    }
}
