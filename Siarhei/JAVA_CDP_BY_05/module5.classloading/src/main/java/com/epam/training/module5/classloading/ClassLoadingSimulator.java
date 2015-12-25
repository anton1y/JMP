package com.epam.training.module5.classloading;

import com.epam.training.module5.models.ClassAndJarLoader;

public class ClassLoadingSimulator {
    public static void main(String[] args) {
        ClassAndJarLoader classAndJarLoader = new ClassAndJarLoader();
        classAndJarLoader.loadJarFile();
    }
}
