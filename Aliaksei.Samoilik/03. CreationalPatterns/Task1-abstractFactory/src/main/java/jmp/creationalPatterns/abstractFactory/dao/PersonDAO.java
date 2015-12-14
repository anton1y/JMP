package jmp.creationalPatterns.abstractFactory.dao;

import java.util.List;

import jmp.creationalPatterns.abstractFactory.model.Person;

public interface PersonDAO {
    public void writePerson(Person person);

    public List<Person> readPersons();

    public Person find(int id);
}
