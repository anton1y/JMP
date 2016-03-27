package com.epam.training.module15.client;

import java.util.List;

import com.epam.training.module15.model.ChampionshipService;
import com.epam.training.module15.model.ChampionshipServiceService;
import com.epam.training.module15.model.TotalCard;
import com.epam.training.module15.model.WeatherInCity;

public class ChampionshipServiceClient {
    public static void main(String[] args) {
        ChampionshipServiceService championshipServiceService = new ChampionshipServiceService();
        ChampionshipService service = championshipServiceService.getChampionshipServicePort();

        TotalCard totalCard = service.cardsPerTeam("Costa Rica");
        System.out.println("number red card:" + totalCard.getRedCard());
        System.out.println("number yellow card:" + totalCard.getYellowCard());
        List<WeatherInCity> weatherInCities = service.getWeatherInCity("Brazil");
        for (WeatherInCity weatherInCity : weatherInCities) {
            System.out.println("__________________________________________");
            System.out.println("city:" + weatherInCity.getCity());
            if (weatherInCity.getWeather() != null) {

                System.out.println("dewPoint:" + weatherInCity.getWeather().getDewPoint());
                System.out.println("location:" + weatherInCity.getWeather().getLocation());
                System.out.println("pressure:" + weatherInCity.getWeather().getPressure());
                System.out.println("RelativeHumidity:" + weatherInCity.getWeather().getRelativeHumidity());
                System.out.println("GetSkyConditions:" + weatherInCity.getWeather().getSkyConditions());
                System.out.println("Temperature:" + weatherInCity.getWeather().getTemperature());
            }
            System.out.println("__________________________________________");
        }
    }

}
