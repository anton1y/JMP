package com.epam.training.module01.behavior;

import com.epam.training.module01.interfaces.WeaponBehavior;

public class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
       System.out.print("use knife");
    }

}
