package jmp.creationalPatterns.singleton.hero;

import jmp.creationalPatterns.singleton.citizens.Man;

public enum SingleSuperHero implements HeroInterface {
    INSTANCE;
    public static SingleSuperHero getInstance() {
        return INSTANCE;
    }

    @Override
    public void makePeapleHappy(Man man) {
        System.out.println("I, hero, made a " + man.getName() + " happy");
        man.setIamInTrouble(false);
    }
}
