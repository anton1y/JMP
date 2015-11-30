package com.epam.training.module01.models;

public class Troll extends Character {

    @Override
    public void saySpeech() {
        System.out.print("I'm troll. I ");
        useWeapon();
    }

}
