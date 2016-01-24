package com.epam.training.module7.garbageCollection;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        while (true) {
            List<List> bufferList = new ArrayList<List>();
            for (int i = 0; i < 10000; i++) {
                bufferList.add(new ArrayList<Object>());
            }
            for (List list : bufferList) {
                list = null;
            }
        }
    }
}
