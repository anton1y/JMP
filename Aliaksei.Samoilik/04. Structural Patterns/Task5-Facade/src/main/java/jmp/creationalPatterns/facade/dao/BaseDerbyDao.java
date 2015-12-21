package jmp.creationalPatterns.facade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDerbyDao {
    private String dbPath;

    public BaseDerbyDao(String dbPath) {
        this.dbPath = dbPath;
    }

    Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby:" + dbPath + ";");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
}
