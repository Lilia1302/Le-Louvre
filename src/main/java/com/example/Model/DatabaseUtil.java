package com.example.Model;

import java.sql.*;

import com.example.Interface.IDatabaseUtil;

public class DatabaseUtil implements IDatabaseUtil {
    private DBConnection dbConnection;

    public DatabaseUtil() {
        dbConnection = new DBConnection();
    }

    @Override
    public boolean addUser(String firstName, String lastName, String username, String password, String email, String address, String telNumber) {
        try {
            Connection conn = dbConnection.init(null);
            Statement stm = conn.createStatement();

            String sql = "INSERT INTO artiste(firstName, lastName, username, image, email, address, telNumber, password) VALUES ('" + firstName + "','" + lastName + "','" + username + "','image','" + email + "','" + address +"','" + telNumber + "','" + password +"')";

            int result = stm.executeUpdate(sql);

            if (result == 1) {
               return true;
            }
        } catch (SQLException e) {
            System.out.println("Failed to add user to database: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean userExists(String email, String password) {
        // Code pour vérifier si un utilisateur existe déjà dans la base de données
        try {
            Connection conn = dbConnection.init(null);
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM artiste WHERE email='"+email+"' AND password='"+password+"'";
            ResultSet resultSet = stm.executeQuery(sql);

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Failed to add user to database: " + e.getMessage());
        }
        return false;
        
    }

    @Override
    public boolean emailExists(String email) {
        // Code pour vérifier si une adresse email existe déjà dans la base de données
        return false;
    }
}
