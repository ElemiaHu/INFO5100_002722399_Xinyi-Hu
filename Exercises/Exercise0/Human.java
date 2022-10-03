package com.example.exercise;

public class Human {
    String name;
    String race;
    String gender;
    String occupation;
    String hairColor;
    boolean glasses;
    float height;
    float weight;

    Human(){}

    Human(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public void greetings(){
        System.out.println("Hello. Nice to meet you.");
    }

    public void apology(){
        System.out.println("I'm sorry.");
    }

    public void affection(){
        System.out.println("Awww! This is so cute!");
    }
}
