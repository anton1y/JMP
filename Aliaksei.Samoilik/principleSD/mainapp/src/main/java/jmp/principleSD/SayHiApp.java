package jmp.principleSD;

import jmp.principleSD.common.SayHiModuleCreator;
import jmp.principleSD.common.sayHiInterface.SayHi;

public class SayHiApp {
    public static void main(String[] args) {
        SayHi sayHibyEmail = SayHiModuleCreator.createModule("jmp.principleSD.sayHiImpl.SayHiByEmailImpl");
        SayHi sayHibySms = SayHiModuleCreator.createModule("jmp.principleSD.sayHiImpl.SayHiBySmsImpl");
        sayHibyEmail.sendHiMessage("hello my friend A");
        sayHibyEmail.sendHiMessage("hello my friend B");
        sayHibySms.sendHiMessage("hello my friend A again");
    }
}