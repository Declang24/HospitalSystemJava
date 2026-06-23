package com.hospital.hospitalsystem.service;

import com.hospital.hospitalsystem.database.dbManager;
import com.hospital.hospitalsystem.model.User;

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
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ListAllUsers()
    {
        String sql = "SELECT * FROM users";

        try(Connection conn = dbManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql))
        {
            System.out.println("\n-- Registered Users --");
            System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", "ID", "Name", "Email", "Age", "Gender", "Role");
            System.out.println("---------+--------------------+--------------------------------+------+--------+--------+--");
            while(result.next())
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String age = result.getString("age");
                String gender = result.getString("gender");
                String role = result.getString("role");
                System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", id, name, email, age, gender, role);
                System.out.print("");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    public static void ListAllDoctors()
    {
        String sql = "SELECT * FROM users WHERE role = 'doctor'";

        try(Connection conn = dbManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql))
        {
            System.out.println("\n-- Doctors --");
            System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", "ID", "Name", "Email", "Age", "Gender", "Role");
            System.out.println("---------+--------------------+--------------------------------+------+--------+--------+--");
            while(result.next())
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String age = result.getString("age");
                String gender = result.getString("gender");
                String role = result.getString("role");
                System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", id, name, email, age, gender, role);
                System.out.print("");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    public static void ListAllPatients()
    {
        String sql = "SELECT * FROM users WHERE role = 'patient'";

        try(Connection conn = dbManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql))
        {
            System.out.println("\n-- Patients --");
            System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", "ID", "Name", "Email", "Age", "Gender", "Role");
            System.out.println("---------+--------------------+--------------------------------+------+--------+--------+--");
            while(result.next())
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String age = result.getString("age");
                String gender = result.getString("gender");
                String role = result.getString("role");
                System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", id, name, email, age, gender, role);
                System.out.print("");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    public static void listUserByID(int idSearch)
    {
        String sql = "SELECT * FROM users WHERE id = ?";

        try(Connection conn = dbManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setInt(1, idSearch);
            ResultSet result = statement.executeQuery();

            if(result.next())
            {
                System.out.println("\n-- Search Results --");
                System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", "ID", "Name", "Email", "Age", "Gender", "Role");
                System.out.println("---------+--------------------+--------------------------------+------+--------+--------+--");
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String age = result.getString("age");
                String gender = result.getString("gender");
                String role = result.getString("role");
                System.out.printf("|%-8s|%-20s|%-32s|%-6s|%-8s|%-8s|\n", id, name, email, age, gender, role);
                System.out.print("");
            }
            else
            {
                System.out.println("No user found with this ID.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }
}
