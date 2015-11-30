package com.epam.training.module01.utils;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.module01.factories.CharacterFactory;
import com.epam.training.module01.factories.WeaponFactory;
import com.epam.training.module01.interfaces.WeaponBehavior;
import com.epam.training.module01.models.Character;
public class GenerationUtils {

    public static List<Character> genearteListOfCharacters(int numberOfCharacter) {
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < numberOfCharacter; i++) {
            list.add(CharacterFactory.createCharacter());
        }
        return list;
    }

    public static List<WeaponBehavior> generateListOfWeapon(int numberOfWeapon) {
        List<WeaponBehavior> list = new ArrayList<WeaponBehavior>();
        for (int i = 0; i < numberOfWeapon; i++) {
            list.add(WeaponFactory.createWeapon());
        }
        return list;
    }
}
