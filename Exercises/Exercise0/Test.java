package com.example.exercise;

public class Test {
    public static void main(String[] args){
        Laptop myPC = new Laptop();
        myPC.displayInput();
        myPC.playYoutube();

        Human yoko = new Human("Yoko", "Female");
        Human someone = new Human();
        someone.greetings();
        yoko.affection();

        Cat momo = new Cat("momo");
        momo.hungry();

        Cake myCake = new Cake();
        myCake.checkVegan();
    }
}
