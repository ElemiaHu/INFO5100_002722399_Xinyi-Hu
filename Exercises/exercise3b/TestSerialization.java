package com.example.exercise3b;

import java.io.*;

public class TestSerialization {

    public static void main (String[] args) {
        Circle c = new Circle(3.5);

        try{
            FileOutputStream fileOut = new FileOutputStream("circle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.out.println("Error");
        }

        Circle circle = new Circle();
        try {
            FileInputStream fileIn = new FileInputStream("circle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            circle = (Circle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println(i.toString());
        } catch (ClassNotFoundException i) {
            System.out.println(i.toString());
        }

        System.out.println("Circle\n" + "radius: " + circle.radius);
    }
}
