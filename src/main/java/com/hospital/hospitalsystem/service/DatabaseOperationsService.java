package com.hospital.hospitalsystem.service;

import com.hospital.hospitalsystem.database.dbManager;
import com.hospital.hospitalsystem.model.User;
import com.hospital.hospitalsystem.utility.Logger;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperationsService {

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

        Logger.log("User " + idSearch + " was retrieved from the database");
    }

    public static void deleteUserByID(int idSearch)
    {
        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection conn = dbManager.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setInt(1, idSearch);

            int deletedRows = statement.executeUpdate();

            if(deletedRows > 0)
            {
                System.out.println("User " + idSearch + " has been successfully removed.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error: Something has gone wrong, please try again later.");
        }

        Logger.log("User " + idSearch + " was removed from the database");
    }

}
