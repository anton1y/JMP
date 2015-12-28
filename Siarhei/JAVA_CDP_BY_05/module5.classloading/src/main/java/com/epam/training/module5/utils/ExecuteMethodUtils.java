package com.epam.training.module5.utils;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ExecuteMethodUtils {
    public static final Logger logger = Logger.getLogger(ExecuteMethodUtils.class);
    public static void executeMethodForLoadedClass(Class<?> loadedClass, String methodName){
        try {
            Method[] methods = loadedClass.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    logger.info("Method with this name found");
                    executeMethod(loadedClass, method);
                    logger.info("Method successfully executed");
                }
            }
        } catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            logger.error("Problem with executing method", e);
        }
    }
    
    private static void  executeMethod(Class<?> classToLoad, Method method) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Class<?>[] classes= method.getParameterTypes();
        Object instance = classToLoad.newInstance();
        if (classes.length==0) {
            method.invoke(instance);
        } else {
            
            List<Object> lists = new ArrayList<Object>();
            for (Class<?> class1 : classes) {
                logger.info("Parameter :"+class1.getSimpleName());
                if (class1.isArray()) {
                    lists.add(Array.newInstance(class1.getComponentType(),1));
                } else {
                    lists.add(class1.newInstance());
                }
            }
             method.invoke(instance, lists.toArray());
        }
    }

}
