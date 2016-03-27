package com.epam.training.module15;


import javax.xml.ws.Endpoint;


import com.epam.training.module15.service.ChampionshipService;

public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9876/ws/ChampionshipService", new ChampionshipService());
    }
}
