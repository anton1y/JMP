package com.epam.training.module01.simulator;

import java.util.List;

import com.epam.training.module01.interfaces.WeaponBehavior;
import com.epam.training.module01.models.Character;
import com.epam.training.module01.services.WeaponService;
import com.epam.training.module01.utils.GenerationUtils;

public class MiniCharacterSimulator {

    public static void main (String[] args) {
        List<Character> characters = GenerationUtils.genearteListOfCharacters(7);
        List<WeaponBehavior> weapon = GenerationUtils.generateListOfWeapon(7);
        WeaponService.distributeWeapons(characters, weapon);
        for (Character character : characters) {
            character.saySpeech();
            WeaponService.checkCharactersWeapons(character);
        }
    }
}
