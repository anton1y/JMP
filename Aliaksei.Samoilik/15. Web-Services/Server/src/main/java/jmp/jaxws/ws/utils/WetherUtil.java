package jmp.jaxws.ws.utils;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jmp.jaxws.ws.model.CurrentWeather;

public class WetherUtil {
    public static CurrentWeather xml2CurrentWeather(String xml) {
        CurrentWeather currentWeather = null;

        try {
            JAXBContext jaxbContext = JAXBContext
                    .newInstance(CurrentWeather.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Reader reader = new StringReader(xml);
            currentWeather = (CurrentWeather) jaxbUnmarshaller
                    .unmarshal(reader);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return currentWeather;
    }
}
