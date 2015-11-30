package jmp.principleSD.common;
import java.lang.reflect.InvocationTargetException;

import jmp.principleSD.common.sayHiInterface.SayHi;

public class SayHiModuleCreator {
    public static SayHi createModule(String className){
        SayHi sayHi = null;
        try {
            sayHi = (SayHi)Class.forName(className).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sayHi;
    }
}
