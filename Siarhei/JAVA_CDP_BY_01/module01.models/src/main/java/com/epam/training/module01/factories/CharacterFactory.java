package com.epam.training.module01.factories;

import java.util.Random;

import com.epam.training.module01.models.Archer;
import com.epam.training.module01.models.Character;
import com.epam.training.module01.models.King;
import com.epam.training.module01.models.Knight;
import com.epam.training.module01.models.Queen;
import com.epam.training.module01.models.Troll;


public class CharacterFactory {
    public static Character createCharacter(){
        int number = new Random().nextInt(5);
        switch (number) {
        case 0:
            return new Archer();
        case 1:
            return new King();
        case 2:
            return new Knight();
        case 3:
            return new Queen();
        case 4:
            return new Troll();
        default:
            return new Character() {
                @Override
                public void saySpeech() {
                    System.out.println("I'm  impossible person");
                }
            };
        }
    }
}
