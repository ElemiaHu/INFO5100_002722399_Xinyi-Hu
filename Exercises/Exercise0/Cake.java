package com.example.exercise;

public class Cake {
    String flavor;
    String[] ingredients;
    String color;
    String shape;
    String texture;
    boolean vegan = false;
    float weight;
    String bestBefore;

    Cake(){}

    public void getIngredients(){}
    public void checkVegan(){
        System.out.println(vegan ? "This cake is suitable for vegans!" : "This cake is not vegan!");
    }
    public void getFlavor(){
        System.out.println(flavor);
    }

}
