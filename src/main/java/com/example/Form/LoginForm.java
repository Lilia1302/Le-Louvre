package com.example.Form;

import java.sql.*;
import javax.swing.*;

import com.example.Model.Artiste;
import com.example.Model.DBConnection;
import com.example.View.LoginView;

public class LoginForm {  
    Connection conn;
    DBConnection dbConnection;
    
    public Artiste getAuthentificatedUser(String email, String password){
        Artiste artiste = null;

        try {
            dbConnection = new DBConnection();
           conn= dbConnection.init(conn);
            // Connected to database successfully...
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM artiste WHERE email='"+email+"' AND password='"+password+"'";
            ResultSet resultSet = stm.executeQuery(sql);

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Matched Email and Password!");

                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String username = resultSet.getString("username");
                String image = resultSet.getString("image");
                email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String telNumber = resultSet.getString("telNumber");
                password = resultSet.getString("password");
                artiste = new Artiste(firstName, lastName, username, image, email, telNumber, address, password);
            }
            stm.close();
            conn.close();

        } catch(Exception e){
            System.out.println("Database connexion failed!");
        }
        return artiste;
        }

        public static void main(String[] args) {
            LoginView lgview = new LoginView();
            lgview.initialize();
        }

    }
