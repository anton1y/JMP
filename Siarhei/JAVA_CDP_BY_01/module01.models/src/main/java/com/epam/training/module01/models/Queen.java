package com.epam.training.module01.models;

public class Queen extends Character {

    @Override
    public void saySpeech() {
        System.out.print("I'm queen. I ");
        useWeapon();
    }
}
