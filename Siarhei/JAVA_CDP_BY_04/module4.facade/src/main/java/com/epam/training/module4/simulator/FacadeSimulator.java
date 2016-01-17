package com.epam.training.module4.simulator;


import com.epam.training.module4.models.FacadeForDBConnection;

public class FacadeSimulator {
    public static void main(String[] args) {
        FacadeForDBConnection facadeForDBConnection = new FacadeForDBConnection();
        facadeForDBConnection.writePerson();
        facadeForDBConnection.readPersons();
    }
}
