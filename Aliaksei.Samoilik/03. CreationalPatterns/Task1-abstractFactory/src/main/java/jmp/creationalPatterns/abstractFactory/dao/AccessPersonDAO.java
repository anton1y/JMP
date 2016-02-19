package jmp.creationalpatterns.abstractfactory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jmp.creationalpatterns.abstractfactory.model.Person;
import jmp.creationalpatterns.abstractfactory.utils.DatabaseUtils;

public class AccessPersonDAO implements PersonDAO {

    private static final Log LOG = LogFactory.getLog(AccessPersonDAO.class);

    private static final String DB_ERROR = "db error";

    private String fileName;

    public AccessPersonDAO(String fileName) {
        this.fileName = fileName;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://" + fileName);
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(DB_ERROR, e);
        }
        return conn;
    }

    @Override
    public void writePerson(Person person) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO Person(FirstName, LastName) VALUES ( ?, ?)");
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOG.error(DB_ERROR, e);
        } finally {
            DatabaseUtils.close(stmt);
            DatabaseUtils.close(conn);
        }
    }

    @Override
    public List<Person> readPersons() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Person> personList = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Person");
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                personList.add(person);
            }
            rs.close();
        } catch (SQLException e) {
            LOG.error(DB_ERROR, e);
        } finally {
            DatabaseUtils.close(rs);
            DatabaseUtils.close(stmt);
            DatabaseUtils.close(conn);
        }
        return personList;
    }

    @Override
    public Person find(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Person person = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Person where id =" + id);
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            LOG.error(DB_ERROR, e);
        } finally {
            DatabaseUtils.close(rs);
            DatabaseUtils.close(stmt);
            DatabaseUtils.close(conn);
        }
        return person;
    }

}
