package jmp.creationalPatterns.singleton.hero;

import jmp.creationalPatterns.singleton.citizens.Man;

public class SingleSuperMan extends Man implements HeroInterface {
    public SingleSuperMan(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    private static volatile SingleSuperMan instance;

    public static SingleSuperMan getInstance() {
        SingleSuperMan localInstance = instance;
        if (localInstance == null) {
            synchronized (SingleSuperMan.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingleSuperMan("Super man");
                }
            }
        }
        return localInstance;
    }

    @Override
    public void makePeapleHappy(Man man) {
        System.out.println("I, " + getName() + ", made a " + man.getName() + " happy");
        man.setIamInTrouble(false);
    }

    public void fly() {
        System.out.println("Fly as a super man");

    }
}