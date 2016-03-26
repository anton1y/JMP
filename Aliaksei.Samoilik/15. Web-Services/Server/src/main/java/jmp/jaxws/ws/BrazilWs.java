package jmp.jaxws.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import jmp.jaxws.client.football.ArrayOfString;
import jmp.jaxws.client.football.ArrayOftPlayersWithCards;
import jmp.jaxws.client.football.Info;
import jmp.jaxws.client.football.InfoSoapType;
import jmp.jaxws.client.football.TPlayersWithCards;
import jmp.jaxws.client.weather.GlobalWeather;
import jmp.jaxws.client.weather.GlobalWeatherSoap;
import jmp.jaxws.ws.model.CardAmount;
import jmp.jaxws.ws.model.CurrentWeather;
import jmp.jaxws.ws.model.WeatherPerCities;
import jmp.jaxws.ws.utils.WetherUtil;

@WebService
public class BrazilWs {

    InfoSoapType footballInfoClient = new Info().getInfoSoap();

    GlobalWeatherSoap weatherClient = new GlobalWeather()
            .getGlobalWeatherSoap();
    
    @WebMethod
    public CardAmount getCards(String team) {
        ArrayOftPlayersWithCards playersWithRedCard = footballInfoClient
                .allPlayersWithRedCards(true, true);
        ArrayOftPlayersWithCards playersWithYellowCard = footballInfoClient
                .allPlayersWithYellowCards(true, true);

        int redCardAmount = playersWithRedCard.getTPlayersWithCards().stream()
                .filter(p -> team.equalsIgnoreCase(p.getSTeamName()))
                .mapToInt(TPlayersWithCards::getIRedCards).sum();
        int yellowCardAmount = playersWithYellowCard.getTPlayersWithCards()
                .stream().filter(p -> team.equalsIgnoreCase(p.getSTeamName()))
                .mapToInt(TPlayersWithCards::getIYellowCards).sum();

        CardAmount cardAmount = new CardAmount();
        cardAmount.setRedCard(redCardAmount);
        cardAmount.setYellowCard(yellowCardAmount);

        return cardAmount;
    }

    @WebMethod
    public String sayHello(String name) {
        return name + ".";
    }

    @WebMethod
    public List<WeatherPerCities> getWeatherPerCities(String country){
        List<WeatherPerCities> arrayList = new ArrayList<WeatherPerCities>();
        ArrayOfString cities = footballInfoClient.cities();
        for (String city : cities.getString()) {
            String weather = weatherClient.getWeather(city, country);
            CurrentWeather currentWether = WetherUtil.xml2CurrentWeather(weather);
            WeatherPerCities weatherPerCities = new WeatherPerCities();
            weatherPerCities.setCity(city);
            weatherPerCities.setWeather(currentWether);
            arrayList.add(weatherPerCities);
        }
        return arrayList;
    }

}