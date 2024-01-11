package com.college.student.utils;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    //constants
    private final static  String DB_URL = "jdbc:mysql://127.0.0.1:3306/collegeadministration";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD =  "student@1234";
    private static Connection connection;

    public static Connection connect() {
        try {
            if(connection == null || !connection.isClosed()) {
                synchronized (DBConnector.class) {
                    if(connection == null || !connection.isClosed()) {
                        DriverManager.registerDriver(new Driver());
                        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
