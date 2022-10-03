package com.example.exercise;

public class Laptop {
    String brand;
    float size;
    String color;
    String material;
    Display screen;
    Keyboard keyboard = new Keyboard();
    String processor;
    float weight;

    Laptop(){}

    public void displayInput(){
        String input = keyboard.type();
        System.out.println(input);
    }
    public void open(){}
    public void playYoutube(){
        System.out.println("Watch the newest Kardashian on https://www.youtube.com/watch?v=ftmL2eveb7I");
    }


    class Display{
        float length;
        float width;
        String material;
        String model;
        int[] resolution;
        int[] ratio = {16,9};
        String origin = "Made in China";
        int luminance;

        Display(){}

        public void setLuminance(){}
        public int[] getResolution(){ return resolution; }
        public void seeOrigin(){ System.out.println("Made in China"); }
    }
    class Keyboard{
        int numOfKeys;
        String color;
        String material;
        String language;
        float size;
        String connection = "USB";
        boolean backlight;
        String origin = "Made in China";

        Keyboard(){}

        public String type(){ return "Something you typed."; }
        public void setBacklightOn(){ backlight = true; }
        public int getNumOfKeys(){ return numOfKeys; }
    }
}
