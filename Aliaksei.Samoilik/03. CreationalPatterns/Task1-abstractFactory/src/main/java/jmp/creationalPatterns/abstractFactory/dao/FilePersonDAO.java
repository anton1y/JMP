package jmp.creationalpatterns.abstractfactory.dao;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jmp.creationalpatterns.abstractfactory.model.Person;

public class FilePersonDAO implements PersonDAO {
    private String fileName;

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
        int maxId = persons.isEmpty() ? 0
                : persons.get(persons.size() - 1).getId();
        person.setId(maxId + 1);
        persons.add(person);
        Gson gson = new Gson();
        try {
            FileUtils.writeStringToFile(new File(fileName), gson.toJson(persons), "UTF-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readPersons() {
        String contect;
        List<Person> persons = new ArrayList<>();
        try {
            contect = FileUtils.readFileToString(new File(fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return persons;
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>() {
        }.getType();
        persons = gson.fromJson(contect, listType);
        return persons;
    }

    @Override
    public Person find(int id) {
        List<Person> persons = readPersons();
        List<Person> filteredList = persons.stream()
                .filter(p -> p.getId() == id).collect(Collectors.toList());
        return filteredList.isEmpty() ? null : filteredList.get(0);
    }

}
