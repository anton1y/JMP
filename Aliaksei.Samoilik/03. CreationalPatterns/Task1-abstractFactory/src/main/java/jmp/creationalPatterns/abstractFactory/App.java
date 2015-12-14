package jmp.creationalPatterns.abstractFactory;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import jmp.creationalPatterns.abstractFactory.dao.PersonDAO;
import jmp.creationalPatterns.abstractFactory.factory.AbstractDAOFactory;
import jmp.creationalPatterns.abstractFactory.model.Person;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AbstractDAOFactory jdbcDAOFactory = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.ACCESS);
        PersonDAO accessPersonDAO = jdbcDAOFactory.getPersonDAO("data.accdb");

        AbstractDAOFactory fileDAOFactory = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.FILE);
        PersonDAO filePersonDAO = fileDAOFactory.getPersonDAO("data.json");

        System.out.println("Access:");
        doClientWork(accessPersonDAO);
        System.out.println("File:");
        doClientWork(filePersonDAO);
        System.out.println("End");
    }

    private static void doClientWork(PersonDAO personDAO) {
        // Add new person
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        // personDAO.writePerson(person);

        // Read all persons
        List<Person> persons = personDAO.readPersons();
        persons.forEach(p -> System.out.println("id:" + p.getId() + "; Name = " + p.getFirstName()));
    }
}
