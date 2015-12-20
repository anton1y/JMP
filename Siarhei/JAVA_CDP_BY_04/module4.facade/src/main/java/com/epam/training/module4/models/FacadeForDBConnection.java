package com.epam.training.module4.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FacadeForDBConnection {

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.err.println("Problem with jdbc driver");
        }
    }
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","test");
        } catch (SQLException e) {
            System.err.println("Problem with creation connection to db");
            throw new RuntimeException("Can't connect to database");
        }
    }

    public void closeConnection(Connection connection) {
        if (connection == null) return;
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem with closing connection");
        }
    }

}
