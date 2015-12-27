package com.epam.training.module5.classloading;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.training.module5.models.ClassAndJarLoader;
import com.epam.training.module5.utils.ExecuteMethodUtils;
import com.epam.training.module5.utils.ReadInformationUtils;

public class ClassLoadingSimulator {
    public static final Logger logger = Logger.getLogger(ClassLoadingSimulator.class);
    public static void main(String[] args) {
        logger.info("Start application");
        logger.info("Please enter name and path to jar file");
        String jarPathName = ReadInformationUtils.readJarFile();
        ClassAndJarLoader classAndJarLoader = new ClassAndJarLoader();
        List<String> classesName = classAndJarLoader.loadClassesNameFromJarFile(jarPathName);
        String classNameForLoad = ReadInformationUtils.readClassNameForLoad(classesName);
        Class<?> loadedClass = classAndJarLoader.loadClass(jarPathName, classNameForLoad);
        String methodForExecute = ReadInformationUtils.readMethodForExecute(loadedClass);
        ExecuteMethodUtils.executeMethodForLoadedClass(loadedClass, methodForExecute);
    }
}
