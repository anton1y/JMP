package jmp.creationalPatterns.abstractFactory.dao;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jmp.creationalPatterns.abstractFactory.model.Person;
import jmp.creationalPatterns.abstractFactory.utils.FileUtils;

public class FilePersonDAO implements PersonDAO {
    String fileName;

    public FilePersonDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writePerson(Person person) {
        List<Person> persons = readPersons();
        if (persons == null) {
            persons = new ArrayList<>();
        }
        persons.sort((Person p1, Person p2) -> p1.getId() - p2.getId());
        int maxId = persons.size() == 0 ? 0 : persons.get(persons.size() - 1).getId();
        person.setId(maxId + 1);
        persons.add(person);
        Gson gson = new Gson();
        FileUtils.writeFile(fileName, gson.toJson(persons));
    }

    @Override
    public List<Person> readPersons() {
        String contect = FileUtils.readFile(fileName);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>() {
        }.getType();
        List<Person> persons = gson.fromJson(contect, listType);
        return persons;
    }

    @Override
    public Person find(int id) {
        List<Person> persons = readPersons();
        List<Person> filteredList = persons.stream().filter((p) -> (p.getId() == id)).collect(Collectors.toList());
        return filteredList.size() == 0 ? null : filteredList.get(0);
    }

}
