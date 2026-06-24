package com.hospital.hospitalsystem.service;

import com.hospital.hospitalsystem.database.dbManager;
import com.hospital.hospitalsystem.model.User;
import com.hospital.hospitalsystem.utility.Logger;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginService {

    public static void registerUser(User user)
    {
        String query = "INSERT INTO users(name, email, age, gender, role) VALUES(?, ?, ?, ?, ?)";

        try(Connection conn = dbManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(query))
        {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getRole());

            statement.executeUpdate();
            System.out.println("Registration successful");
            Logger.log("New user was added to the database. ID = " + user.getID());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
