package jmp.creationalPatterns.abstractFactory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jmp.creationalPatterns.abstractFactory.model.Person;

public class AccessPersonDAO implements PersonDAO {

    private String fileName;

    public AccessPersonDAO(String fileName) {
        this.fileName = fileName;
    }

    // TODO USE Connection pool and probably move to the factory
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://" + fileName);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void writePerson(Person person) {
        Connection conn = null;
        try {
            String sql = "INSERT INTO Person(FirstName, LastName) " + "VALUES ( '" + person.getFirstName() + "', '"
                    + person.getLastName() + "')";
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Person> readPersons() {
        Connection conn = null;
        List<Person> personList = new ArrayList<>();
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Person");
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                personList.add(person);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return personList;
    }

    @Override
    public Person find(int id) {
        Connection conn = null;
        Person person = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Person where id =" + id);
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return person;
    }

}
