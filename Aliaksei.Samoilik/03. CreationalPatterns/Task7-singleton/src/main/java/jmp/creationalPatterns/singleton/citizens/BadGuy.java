package jmp.creationalPatterns.singleton.citizens;

public class BadGuy extends Man {
    public BadGuy(String name) {
        super(name);
    }

    public void makePeapleUnHappy(Man man) {
        System.out.println("I, " + getName() + ", made a " + man.getName() + " unhappy");
        man.setIamInTrouble(true);
    }
}
