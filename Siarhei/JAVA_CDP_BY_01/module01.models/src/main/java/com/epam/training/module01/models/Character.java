package com.epam.training.module01.models;

import com.epam.training.module01.interfaces.WeaponBehavior;

public abstract class Character {

    private WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public WeaponBehavior getWeaponBehavior() {
        return weaponBehavior;
    }

    public abstract void saySpeech();

    protected void useWeapon() {
        if (weaponBehavior != null) {
            weaponBehavior.useWeapon();
        } else {
            System.out.print(" without weapon");
        }

    }

}
