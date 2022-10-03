package com.example.exercise;

public class Cat {
    String name;
    String color;
    String breed;
    float age;
    float weight;
    String gender;
    String favoriteFood;
    boolean fur;

    Cat(){}

    Cat(String name){ this.name = name; }

    public void meow(){
        System.out.println("Meow!");
    }

    public void hungry(){
        System.out.println("Meow! Meow! Meow!");
    }

    public void run(){}
    
}
