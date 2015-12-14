package com.epam.training.module3.sourceInterface;

import java.util.List;

import com.epam.training.module3.models.Person;

public interface Source {
    public void writePerson(Person person);
    public List<Person> readPersons();
    public Person readPerson (String name);
}
