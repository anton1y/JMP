
package com.epam.training.module15.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.training.module15.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CardsPerTeam_QNAME = new QName("http://service.module15.training.epam.com/", "cardsPerTeam");
    private final static QName _GetWeatherInCityResponse_QNAME = new QName("http://service.module15.training.epam.com/", "getWeatherInCityResponse");
    private final static QName _GetWeatherInCity_QNAME = new QName("http://service.module15.training.epam.com/", "getWeatherInCity");
    private final static QName _CurrentWeather_QNAME = new QName("http://service.module15.training.epam.com/", "CurrentWeather");
    private final static QName _CardsPerTeamResponse_QNAME = new QName("http://service.module15.training.epam.com/", "cardsPerTeamResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.training.module15.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CardsPerTeam }
     * 
     */
    public CardsPerTeam createCardsPerTeam() {
        return new CardsPerTeam();
    }

    /**
     * Create an instance of {@link GetWeatherInCityResponse }
     * 
     */
    public GetWeatherInCityResponse createGetWeatherInCityResponse() {
        return new GetWeatherInCityResponse();
    }

    /**
     * Create an instance of {@link GetWeatherInCity }
     * 
     */
    public GetWeatherInCity createGetWeatherInCity() {
        return new GetWeatherInCity();
    }

    /**
     * Create an instance of {@link CardsPerTeamResponse }
     * 
     */
    public CardsPerTeamResponse createCardsPerTeamResponse() {
        return new CardsPerTeamResponse();
    }

    /**
     * Create an instance of {@link CurrentWeather }
     * 
     */
    public CurrentWeather createCurrentWeather() {
        return new CurrentWeather();
    }

    /**
     * Create an instance of {@link WeatherInCity }
     * 
     */
    public WeatherInCity createWeatherInCity() {
        return new WeatherInCity();
    }

    /**
     * Create an instance of {@link TotalCard }
     * 
     */
    public TotalCard createTotalCard() {
        return new TotalCard();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardsPerTeam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.module15.training.epam.com/", name = "cardsPerTeam")
    public JAXBElement<CardsPerTeam> createCardsPerTeam(CardsPerTeam value) {
        return new JAXBElement<CardsPerTeam>(_CardsPerTeam_QNAME, CardsPerTeam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeatherInCityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.module15.training.epam.com/", name = "getWeatherInCityResponse")
    public JAXBElement<GetWeatherInCityResponse> createGetWeatherInCityResponse(GetWeatherInCityResponse value) {
        return new JAXBElement<GetWeatherInCityResponse>(_GetWeatherInCityResponse_QNAME, GetWeatherInCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeatherInCity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.module15.training.epam.com/", name = "getWeatherInCity")
    public JAXBElement<GetWeatherInCity> createGetWeatherInCity(GetWeatherInCity value) {
        return new JAXBElement<GetWeatherInCity>(_GetWeatherInCity_QNAME, GetWeatherInCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrentWeather }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.module15.training.epam.com/", name = "CurrentWeather")
    public JAXBElement<CurrentWeather> createCurrentWeather(CurrentWeather value) {
        return new JAXBElement<CurrentWeather>(_CurrentWeather_QNAME, CurrentWeather.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardsPerTeamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.module15.training.epam.com/", name = "cardsPerTeamResponse")
    public JAXBElement<CardsPerTeamResponse> createCardsPerTeamResponse(CardsPerTeamResponse value) {
        return new JAXBElement<CardsPerTeamResponse>(_CardsPerTeamResponse_QNAME, CardsPerTeamResponse.class, null, value);
    }

}
