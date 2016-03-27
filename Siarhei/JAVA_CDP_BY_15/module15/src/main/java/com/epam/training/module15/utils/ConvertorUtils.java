package com.epam.training.module15.utils;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.training.module15.model.CurrentWeather;

public class ConvertorUtils {
    public static CurrentWeather convertWeather(String xmlWeather) {
        CurrentWeather currentWeather = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrentWeather.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            Reader reader = new StringReader(xmlWeather);
            currentWeather = (CurrentWeather) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return currentWeather;

    }

}
