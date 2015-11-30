package jmp.principleSD.sayHiImpl;

import jmp.principleSD.common.sayHiInterface.SayHi;
import jmp.principleSD.utils.FormatUtil;

public class SayHiByEmailImpl implements SayHi{
    @Override
    public void sendHiMessage(String message) {
        System.out.println(FormatUtil.formatMessage("email", message));
    }
}