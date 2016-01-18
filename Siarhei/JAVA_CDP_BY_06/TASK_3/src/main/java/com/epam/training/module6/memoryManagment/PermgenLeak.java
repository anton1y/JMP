package com.epam.training.module6.memoryManagment;


import javassist.CannotCompileException;

public class PermgenLeak {
    private static javassist.ClassPool cp = javassist.ClassPool.getDefault();
    public static void main(String[] args) throws CannotCompileException, RuntimeException {
        int i = 1;
        while (true) {
            Class clazz = cp.makeClass("com.epam.training.module6.memoryManagment"+i).toClass();
            System.out.println("classs="+clazz.getSimpleName());
            i++;
        }
    }

}
