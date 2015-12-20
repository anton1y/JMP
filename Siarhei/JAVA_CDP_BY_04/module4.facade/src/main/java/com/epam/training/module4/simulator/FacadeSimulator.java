package com.epam.training.module4.simulator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.module4.models.FacadeForDBConnection;
import com.epam.training.module4.models.Person;

public class FacadeSimulator {
    public static void main(String[] args) {
        FacadeForDBConnection facadeForDBConnection = new FacadeForDBConnection();
        List<Person> persons = readPersons(facadeForDBConnection);
        for (Person person : persons) {
            System.out.println("This is person name"+person.getName());
        }
    }

    public static List<Person> readPersons(FacadeForDBConnection facadeForDBConnection) {
        List<Person> result = new ArrayList<Person>();
        Connection connection = null;
        try {
            connection = facadeForDBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from persons");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                result.add(person);
            }
        } catch (SQLException e) {
            System.err.println("Problem with database");
        } finally {
            facadeForDBConnection.closeConnection(connection);
        }
        return result;
    }
}
