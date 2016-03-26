package jmp.jaxws.ws;

import java.net.MalformedURLException;
import java.util.List;

import jmp.jaxws.client.brazilws.BrazilWs;
import jmp.jaxws.client.brazilws.BrazilWsService;
import jmp.jaxws.client.brazilws.CardAmount;
import jmp.jaxws.client.brazilws.WeatherPerCities;

public class JaxWsClient {
    public static void main(String[] args) throws MalformedURLException {
        BrazilWsService brazilWsService = new BrazilWsService();
        BrazilWs brazilWs = brazilWsService.getBrazilWsPort();

        String team = "italy";
        CardAmount cardAmount = brazilWs.getCards("italy");
        System.out.println("- Number of Yellow and Red Cards of " + team + " Team-");
        System.out.println("Red Card: " + cardAmount.getRedCard());
        System.out.println("Yellow Card: " + cardAmount.getYellowCard());
        System.out.println("--------------------");
        System.out.println("-Current Weather for the Cities of the FIFA WM 2014-");

        List<WeatherPerCities> weatherPerCityList = brazilWs
                .getWeatherPerCities("brazil");
        System.out.println(String.format("|%-15s|%-15s|%-30s|", "CITY",
                "TEMPERATURE", "PRESSURE"));
        weatherPerCityList
                .forEach(
                        item -> System.out.println(
                                String.format("|%-15s|%-15s|%-30s|", item.getCity(),
                                        item.getWeather() == null ? "-": item.getWeather().getTemperature(),
                                        item.getWeather() == null ? "-": item.getWeather().getPressure())));
        System.out.println("--------------------");
    }
}
