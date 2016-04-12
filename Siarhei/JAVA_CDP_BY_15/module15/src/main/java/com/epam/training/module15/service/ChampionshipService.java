package com.epam.training.module15.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.epam.training.module15.client.fifa.ArrayOfString;
import com.epam.training.module15.client.fifa.ArrayOftPlayersWithCards;
import com.epam.training.module15.client.fifa.Info;
import com.epam.training.module15.client.fifa.InfoSoapType;
import com.epam.training.module15.client.fifa.TPlayersWithCards;
import com.epam.training.module15.client.weather.GlobalWeather;
import com.epam.training.module15.client.weather.GlobalWeatherSoap;
import com.epam.training.module15.model.TotalCard;
import com.epam.training.module15.model.CurrentWeather;
import com.epam.training.module15.model.WeatherInCity;
import com.epam.training.module15.utils.ConvertorUtils;

@WebService()
public class ChampionshipService {
    private InfoSoapType fifaSoap = new Info().getInfoSoap();

    private GlobalWeatherSoap weatherSoap = new GlobalWeather().getGlobalWeatherSoap();

    @WebMethod
    public TotalCard cardsPerTeam(String team) {
        ArrayOftPlayersWithCards playersWithRedOrYellowCard = fifaSoap.allPlayersWithYellowOrRedCards(false, false,
                false);
        int numberOfRedCard = 0;
        int numberOfYellowCard = 0;
        for (TPlayersWithCards player : playersWithRedOrYellowCard.getTPlayersWithCards()) {
            if (player.getSTeamName().equalsIgnoreCase(team)) {
                numberOfRedCard = numberOfRedCard + player.getIRedCards();
                numberOfYellowCard = numberOfYellowCard + player.getIYellowCards();
            }
        }
        TotalCard cards = new TotalCard();
        cards.setRedCard(numberOfRedCard);
        cards.setYellowCard(numberOfYellowCard);

        return cards;
    }

    @WebMethod
    public List<WeatherInCity> getWeatherInCity(String country) {
        List<WeatherInCity> weatherInCities = new ArrayList<WeatherInCity>();
        ArrayOfString cities = fifaSoap.cities();
        for (String city : cities.getString()) {
            String weatherString = weatherSoap.getWeather(city, country);
            CurrentWeather weather = ConvertorUtils.convertWeather(weatherString);
            WeatherInCity weatherInCity = new WeatherInCity();
            weatherInCity.setCity(city);
            weatherInCity.setWeather(weather);
            weatherInCities.add(weatherInCity);
        }
        return weatherInCities;
    }
}
