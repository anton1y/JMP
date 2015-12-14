package com.epam.training.module03.simulator;

import com.epam.training.module03.models.Superman;

public class SupermanSimulator {
    public static void main(String[] args) {
        System.out.println("Start creation superman");
        Superman.getInstance();
        System.out.println("Superman was create");
    }
}
