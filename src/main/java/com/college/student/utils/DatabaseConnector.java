package com.college.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String dbURL;
    private final String dbUsername;
    private final String dbPassword;
    private Connection connection;
    public DatabaseConnector(String dbURL, String dbUsername, String dbPassword) {
        this.dbURL = dbURL;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.connection = null;
    }
    public Connection connectToDatabase() {
        if(connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                this.connection = DriverManager.getConnection(dbURL,dbUsername, dbPassword);
                return connection;
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return this.connection;
    }
}
