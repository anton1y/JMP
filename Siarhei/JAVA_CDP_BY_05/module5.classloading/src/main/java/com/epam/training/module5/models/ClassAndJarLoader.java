package com.epam.training.module5.models;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassAndJarLoader {

   public void loadJarFile() {
       String fileName="module03.Singleton-0.0.1-SNAPSHOT.jar";
       URLClassLoader child;
    try {
        child = new URLClassLoader (new URL[]{new File(fileName).toURI().toURL()}, this.getClass().getClassLoader());
        Class<?> classToLoad = Class.forName ("com.epam.training.module03.models.Superman", true, child);
        Method method = classToLoad.getDeclaredMethod ("getInstance");
        Object instance = classToLoad.newInstance ();
        Object result = method.invoke (instance);
        System.out.println("result:"+result);
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
   }
}
