package com.epam.training.module3.sourceInterface;

import java.util.List;

import com.epam.training.module3.models.Person;

public interface Source {
  void writePerson(Person person);

  List<Person> readPersons();

  Person readPerson(String name);
}
