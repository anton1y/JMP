package jmp.creationalPatterns.facade.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jmp.creationalPatterns.facade.models.Person;

public class DerbyPersonDao extends BaseDerbyDao {

    public DerbyPersonDao(String dbPath) {
        super(dbPath);
    }

    public Person find(int id) {
        Connection conn = null;
        Person person = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON where ID =" + id);
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("ID"));
                person.setFirstName(rs.getString("FIRSTNAME"));
                person.setLastName(rs.getString("LASTNAME"));
                person.setAccountSystemNo(rs.getString("NO_ACCOUNTSYSTEM"));
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
