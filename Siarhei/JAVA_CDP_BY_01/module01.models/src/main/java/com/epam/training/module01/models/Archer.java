package com.epam.training.module01.models;


public class Archer extends Character {

    @Override
    public void saySpeech() {
        System.out.print("I'm archer, I ");
        useWeapon();

    }

}
