package com.epam.training.module3.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.module3.sourceInterface.Source;

public class DBSource implements Source {
    
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
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

    public Person readPerson(String name) {
        Connection connection = null;
        Person person = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select id,name from persons where name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                return person;
            }
        } catch (SQLException e) {
            System.err.println("Problem with database");
        } finally {
            closeConnection(connection);
        }
        return person;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","test");
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
