package com.epam.training.module15.model;

public class WeatherInCity {

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
