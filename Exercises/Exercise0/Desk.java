package com.example.exercise;

public class Desk {
    float length;
    float width;
    float height;
    int capacity;
    int numOfLegs = 4;
    String brand;
    String color;
    String owner;

    Desk(){}

    Desk(float length, float width){
        this.length = length;
        this.width = width;
    }

    public float getSurfaceArea(){
        return length * width;
    }

    public void setOwner(String owner1){
        owner = owner1;
        System.out.println("You have assigned your desk a new owner!");
    }

    public int getCapacity(){
        System.out.println("This desk is allowed for " + capacity + " people to use at the same time.");
        return capacity;
    }

}
