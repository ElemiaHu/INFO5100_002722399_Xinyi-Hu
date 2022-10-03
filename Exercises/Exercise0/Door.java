package com.example.exercise;

public class Door {
    boolean open = false;
    boolean locked = false;
    boolean peephole = true;
    float height;
    float width;
    String color;
    String material;
    float yearsOfUsage;

    Door(){}

    public void setOpen(boolean open){
        this.open = open;
        if(open){
            System.out.println("The door is open.");
        }else{
            System.out.println("The door is closed.");
        }
    }

    public void setYearsOfUsage(float years){
        yearsOfUsage = years;
    }

    public float getYearsOfUsage(){
        System.out.println("This door has been used for " + yearsOfUsage + " years.");
        return yearsOfUsage;
    }
}
