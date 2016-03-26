package jmp.jaxws.ws.model;

public class WeatherPerCities {

    private String city;

    private CurrentWeather weather;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CurrentWeather getWeather() {
        return weather;
    }

    public void setWeather(CurrentWeather weather) {
        this.weather = weather;
    }

}
