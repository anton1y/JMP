package com.epam.training.module4.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class H2Dao {
    static {
        try{
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e){
            System.err.println("Problem with jdbc driver");
        }
    }
    public void writePerson(Person person) {
        Connection connection = null;
        try {
            connection = getConnection();
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into persons (name) values (?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getName());
            statement.execute();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                person.setId(generatedKey.getLong(1));
            }
        } catch (SQLException e) {
            System.err.println("Problem with database");
        } finally {
            closeConnection(connection);
        }

    }

    public List<Person> readPersons() {
        List<Person> result = new ArrayList<Person>();
        Connection connection = null;
        try {
            connection = getConnection();
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
            closeConnection(connection);
        }
        return result;
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:./test", "sa", "");
        } catch (SQLException e) {
            System.err.println("Problem with creation connection to db");
            throw new RuntimeException("Can't connect to database");
        }
    }

    private void closeConnection(Connection connection) {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem with closing connection");
        }
    }
}
