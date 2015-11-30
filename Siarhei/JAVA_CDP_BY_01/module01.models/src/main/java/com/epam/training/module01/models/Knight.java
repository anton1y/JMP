package com.epam.training.module01.models;

public class Knight extends Character {

    @Override
    public void saySpeech() {
        System.out.print("I'm Knight. I ");
        useWeapon();
    }

}
