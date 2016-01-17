package com.epam.training.module5.models;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;


public class ClassAndJarLoader {

    public static final Logger logger = Logger.getLogger(ClassAndJarLoader.class);
    public List<String> loadClassesNameFromJarFile(String fileName) {
        File file = new File(fileName);
        List<String> listClasses = null;
        try {
            logger.info("Start scanning classes from jar");
            listClasses = scanJarFileForClasses(file);
        } catch (IllegalArgumentException | IOException  | SecurityException e) {
            logger.error("Problem with reading classes from jar",e);
        }
        return listClasses;
    }

    private List<String> scanJarFileForClasses(File file) throws IOException, IllegalArgumentException {
        if (file == null || !file.exists())
            throw new IllegalArgumentException("Invalid jar-file to scan provided");
        if (file.getName().endsWith(".jar")) {
            List<String> foundClasses = new ArrayList<String>();
            try (JarFile jarFile = new JarFile(file)) {
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    if (entry.getName().endsWith(".class")) {
                        String name = entry.getName();
                        name = name.substring(0, name.lastIndexOf(".class"));
                        if (name.indexOf("/") != -1)
                            name = name.replaceAll("/", ".");
                        if (name.indexOf("\\") != -1)
                            name = name.replaceAll("\\", ".");
                        foundClasses.add(name);
                    }
                }
            }
            return foundClasses;
        }
        throw new IllegalArgumentException("No jar-file provided");
    }

    public Class<?> loadClass(String jarPathName, String readClassNameForLoad) {
        URLClassLoader child;
        Class<?> classToLoad = null;
        try {
            child = new URLClassLoader(new URL[] { new File(jarPathName).toURI().toURL() }, this.getClass().getClassLoader());
            classToLoad = Class.forName(readClassNameForLoad, true, child);
        } catch (MalformedURLException | ClassNotFoundException e) {
            logger.error("Problem with loading class",e);
        }

        return classToLoad;
    }
}
