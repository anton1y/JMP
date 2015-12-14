package com.epam.training.module03.models;

public class Superman {

    public volatile static Superman superman;
    
    private Superman() {
        
    }
    
    public static Superman getInstance() {
        if (superman == null) {
            synchronized (Superman.class) {
                if (superman == null) {
                    superman = new Superman();
                }
            }
        }
        return superman;
    }
}
