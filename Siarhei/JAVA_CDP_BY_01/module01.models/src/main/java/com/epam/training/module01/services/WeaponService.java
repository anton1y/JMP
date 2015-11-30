package com.epam.training.module01.services;

import java.util.List;

import com.epam.training.module01.behavior.AxeBehavior;
import com.epam.training.module01.behavior.BowAndArrowBehavior;
import com.epam.training.module01.behavior.CudgelBehavior;
import com.epam.training.module01.behavior.KnifeBehavior;
import com.epam.training.module01.behavior.SwordBehavior;
import com.epam.training.module01.interfaces.WeaponBehavior;
import com.epam.training.module01.models.Archer;
import com.epam.training.module01.models.Character;
import com.epam.training.module01.models.King;
import com.epam.training.module01.models.Knight;
import com.epam.training.module01.models.Queen;
import com.epam.training.module01.models.Troll;

public class WeaponService {
    public static void distributeWeapons(List<Character> listOfCharacter, List<WeaponBehavior> weapon){
        for (Character character : listOfCharacter) {
            int sizeWeapon = weapon.size();
            character.setWeaponBehavior(listOfCharacter.indexOf(character) < sizeWeapon ? weapon.get(listOfCharacter.indexOf(character)) : null);
        }
    }

    public static void checkCharactersWeapons(Character character){
        if ((character.getClass() == Archer.class && character.getWeaponBehavior().getClass() == BowAndArrowBehavior.class)
                || (character.getClass() == King.class && character.getWeaponBehavior().getClass() == SwordBehavior.class) 
                || (character.getClass() == Queen.class && character.getWeaponBehavior().getClass() == KnifeBehavior.class)
                ||(character.getClass() == Knight.class && character.getWeaponBehavior().getClass() == AxeBehavior.class) 
                || (character.getClass() == Troll.class) && character.getWeaponBehavior().getClass() == CudgelBehavior.class) {
            System.out.println(" I so happy it's my favority weapon");
        } else {
            System.out.println(" I scared It's not my weapon ");
        }
    }
}
