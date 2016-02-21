package jmp.creationalpatterns.abstractfactory;

import java.sql.SQLException;
import java.util.List;
import jmp.creationalpatterns.abstractfactory.dao.PersonDAO;
import jmp.creationalpatterns.abstractfactory.factory.AbstractDAOFactory;
import jmp.creationalpatterns.abstractfactory.model.Person;

/**
 * Main class.
 * @author Aliaksei Samoilik
 * @version 2.0, Feb 2016
 */
public final class App {
    /**
     * Hide constructor.
     */
    private App() {

    }

    /**
     * main method.
     * @param args
     *            input paramets
     * @throws ClassNotFoundException
     *             class is not found
     * @throws SQLException
     *             database error @date, Feb 2016
     */
    public static void main(final String[] args)
            throws ClassNotFoundException, SQLException {
        AbstractDAOFactory jdbcDAOFactory = AbstractDAOFactory
                .getDAOFactory(AbstractDAOFactory.ACCESS);
        PersonDAO accessPersonDAO = jdbcDAOFactory.getPersonDAO("data.accdb");

        AbstractDAOFactory fileDAOFactory = AbstractDAOFactory
                .getDAOFactory(AbstractDAOFactory.FILE);
        PersonDAO filePersonDAO = fileDAOFactory.getPersonDAO("data.json");

        System.out.println("Access:");
        doClientWork(accessPersonDAO);
        System.out.println("File:");
        doClientWork(filePersonDAO);
        System.out.println("End");
    }

    /**
     * Doing a client work.
     * @param personDAO
     *            doaObject to use
     * @date 2.0, Feb 2016
     */
    private static void doClientWork(final PersonDAO personDAO) {
        // Add new person
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        personDAO.writePerson(person);

        // Read all persons
        List<Person> persons = personDAO.readPersons();
        persons.forEach(p -> System.out
                .println("id:" + p.getId() + "; Name = " + p.getFirstName()));
    }
}
