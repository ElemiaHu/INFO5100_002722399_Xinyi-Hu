package com.example.Exercise2;

public class Square extends Shape{

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
