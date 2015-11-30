 package com.epam.training.module01.factories;

import java.util.Random;

import com.epam.training.module01.behavior.AxeBehavior;
import com.epam.training.module01.behavior.BowAndArrowBehavior;
import com.epam.training.module01.behavior.CudgelBehavior;
import com.epam.training.module01.behavior.KnifeBehavior;
import com.epam.training.module01.behavior.SwordBehavior;
import com.epam.training.module01.interfaces.WeaponBehavior;

public class WeaponFactory {
    public static WeaponBehavior createWeapon(){
        int number = new Random().nextInt(5);
            switch (number) {
            case 0:
                return new AxeBehavior();
            case 1:
                return new BowAndArrowBehavior();
            case 2:
                return new CudgelBehavior();
            case 3:
                return new KnifeBehavior();
            case 4:
                return new SwordBehavior();
            default:
                return new WeaponBehavior() {
                    @Override
                    public void useWeapon() {
                        System.out.println("use magic weapon");
                    }
                };
        }
    }
}
