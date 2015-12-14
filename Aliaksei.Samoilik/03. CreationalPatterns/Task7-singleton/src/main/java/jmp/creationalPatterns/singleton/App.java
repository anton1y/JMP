package jmp.creationalPatterns.singleton;

import jmp.creationalPatterns.singleton.citizens.BadGuy;
import jmp.creationalPatterns.singleton.citizens.Man;
import jmp.creationalPatterns.singleton.hero.SingleSuperHero;
import jmp.creationalPatterns.singleton.hero.SingleSuperMan;

public class App {
    public static void main(String[] args) {
        System.out.println("Story beginning");
        BadGuy badGuy1 = new BadGuy("badGuy1");
        BadGuy badGuy2 = new BadGuy("badGuy2");
        BadGuy badGuy3 = new BadGuy("badGuy3");

        Man poorCitizen1 = new Man("poorCitizen1");
        Man poorCitizen2 = new Man("poorCitizen2");
        Man poorCitizen3 = new Man("poorCitizen3");

        // badGuy makes some evil think against Citizen
        badGuy1.makePeapleUnHappy(poorCitizen1);
        // SingleSuperMan save a man
        SingleSuperMan.getInstance().makePeapleHappy(poorCitizen1);
        // another badGuy makes some evil think against another citizen
        badGuy2.makePeapleUnHappy(poorCitizen2);
        // same SingleSuperMan save a man
        SingleSuperMan.getInstance().makePeapleHappy(poorCitizen2);

        // another badGuy makes some evil think against another citizen
        badGuy3.makePeapleUnHappy(poorCitizen3);
        // another SingleSuperHero(not a map because Enum can't extends Class
        // but it is a good wau to create singleton) save a man
        SingleSuperHero.getInstance().makePeapleHappy(poorCitizen3);
        System.out.println("End of the story");
    }
}
