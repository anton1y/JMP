package com.epam.training.module4.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.epam.training.module4.models.Person;

public class PersonUtils {
    public  String readName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter username ");
        try {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Problem with reading data from console");
        }
        return null;
    }

    public void showPersons(List<Person> lists) {
        for (Person person : lists) {
            System.out.println("This is person name:"+person.getName());
        }
    }

}
