package jmp.creationalpatterns.abstractfactory.dao;

import java.util.List;

import jmp.creationalpatterns.abstractfactory.model.Person;

public interface PersonDAO {
    void writePerson(Person person);

    List<Person> readPersons();

    Person find(int id);
}
