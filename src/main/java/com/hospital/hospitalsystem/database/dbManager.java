package com.hospital.hospitalsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbManager {

    private static final String url = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String name = "root";
    private static final String pass = "password1";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, name, pass);
    }
}
