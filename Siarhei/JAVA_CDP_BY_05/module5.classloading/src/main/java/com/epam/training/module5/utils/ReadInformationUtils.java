package com.epam.training.module5.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;



public class ReadInformationUtils {
    public static final Logger logger = Logger.getLogger(ReadInformationUtils.class);
    public static String readJarFile(){
        String i = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                i =br.readLine();
            } catch (IOException e) {
                logger.error("Problem with reading jar name and path",e);
            }

         return i;
    }
    public static String readClassNameForLoad(List<String> classesName) {
        logger.info("This is list all classes in jar file, please choose one for loading");
        for (String string : classesName) {
            logger.info(string);
        }
        String i = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                i =br.readLine();
            } catch (IOException e) {
                logger.error("Problem with reading jar name and path",e);
            }
        return i;
    }
    public static String readMethodForExecute(Class<?> loadedClass) {
        logger.info("This is list method in class, please choose one for execute");
        Method[] methods = loadedClass.getDeclaredMethods();
        for (Method method : methods) {
            logger.info(method.getName());
        }
        String i = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                i =br.readLine();
            } catch (IOException e) {
                logger.error("Problem with reading method for execute",e);
            }
        return i;
    }
    public static String readParameterForExecute(String name){
        logger.info("Read parameter for execute");
        String i = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                i =br.readLine();
            } catch (IOException e) {
                logger.error("Problem with reading method for execute",e);
            }
        return i;
    }
    
}
