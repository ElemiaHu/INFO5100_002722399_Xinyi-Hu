package com.example.exercise3b;
import java.io.*;

abstract public class Shape implements Serializable {
    Shape(){}

    public abstract double calculateArea ();
    public abstract double calculatePerimeter ();

}

class Circle extends Shape{
    public static String name = "Circle";
    double radius;
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

class Square extends Shape{

    public static String name = "Square";
    private double sideLength;

    Square () {
        super();
    }

    Square (double sideLength) {
        super();
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea () {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter () {
        return 4 * sideLength;
    }

}

class Rectangle extends Shape{
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

class Triangle extends Shape{
    public static String name = "Triangle";
    private double edge1, edge2, edge3;
    private double angle1, angle2, angle3;
    private double height1, height2, height3;

    Triangle () {
        super();
    }

    Triangle (double edge1, double edge2, double edge3) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;

    }

    @Override
    public double calculateArea () {
        return 0.5 * edge1 * height1;
    }

    @Override
    public double calculatePerimeter () {
        return edge1 + edge2 + edge3;
    }
}


