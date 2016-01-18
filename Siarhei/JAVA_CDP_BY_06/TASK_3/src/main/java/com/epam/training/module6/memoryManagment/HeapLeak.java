package com.epam.training.module6.memoryManagment;


public class HeapLeak {
    public static void main(String[] args) throws ClassNotFoundException {
        String as="";
        while (true) {
            as+=as+"someString";
        }
    }
}
