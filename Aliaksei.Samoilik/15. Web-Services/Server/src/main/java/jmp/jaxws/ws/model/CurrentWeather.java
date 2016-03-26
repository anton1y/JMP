package jmp.jaxws.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CurrentWeather")
public class CurrentWeather {
    private String location;
    private String time;
    private String visibility;
    private String skyConditions;
    private String temperature;
    private String dewPoint;
    private String relativeHumidity;
    private String pressure;

    public String getLocation() {
        return location;
    }

    @XmlElement(name="Location")
    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    @XmlElement(name="Time")
    public void setTime(String time) {
        this.time = time;
    }

    public String getVisibility() {
        return visibility;
    }

    @XmlElement(name="Visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getSkyConditions() {
        return skyConditions;
    }

    @XmlElement(name="SkyConditions")
    public void setSkyConditions(String skyConditions) {
        this.skyConditions = skyConditions;
    }

    public String getTemperature() {
        return temperature;
    }

    @XmlElement(name="Temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    @XmlElement(name="DewPoint")
    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    @XmlElement(name="RelativeHumidity")
    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getPressure() {
        return pressure;
    }

    @XmlElement(name="Pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

}
