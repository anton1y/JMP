package jmp.creationalPatterns.singleton.citizens;

public class Man {

    private String name;
    private boolean iamInTrouble;

    public Man(String name) {
        this.setName(name);
    }

    public void walk() {
        System.out.println("Jump as a man");
    }

    public void run() {
        System.out.println("Run as a man");
    }

    public void jump() {
        System.out.println("Jump as a man");

    }

    public boolean isIamInTrouble() {
        return iamInTrouble;
    }

    public void setIamInTrouble(boolean iamInTrouble) {
        if (iamInTrouble) {
            System.out.println("I (" + getName() + ") am unhappy");
        } else {
            System.out.println("I (" + getName() + ") am happy");
        }
        this.iamInTrouble = iamInTrouble;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
