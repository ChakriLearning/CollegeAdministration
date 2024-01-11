package com.college.student.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String dbURL;
    private final String dbUsername;
    private final String dbPassword;
    public DatabaseConnector(String dbURL, String dbUsername, String dbPassword) {
        this.dbURL = dbURL;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }
    public Connection conectToDatabase() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dbURL,dbUsername, dbPassword);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }
}
