package com.epam.training.module01.models;

public class King extends Character {

    @Override
    public void saySpeech() {
        System.out.print("I'm King. I ");
        useWeapon();
    }
}
