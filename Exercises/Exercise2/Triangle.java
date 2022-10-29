package com.example.Exercise2;

public class Triangle extends Shape{
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
