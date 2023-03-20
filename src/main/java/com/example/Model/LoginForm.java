package com.example.Model;

import java.sql.*;
import javax.swing.*;

import com.example.View.loginView;

public class LoginForm {  
    Connection conn;
    DBConnection dbConnection;
    
    public Artiste getAuthentificatedUser(String email, String password){
        Artiste artiste = null;

       
         
        try {
            System.out.println("coucou je me suis rentrée !");
            dbConnection = new DBConnection();
           conn= dbConnection.init(conn);
           System.out.println("coucou je me suis connecté");
            // Connected to database successfully...
            Statement stm = conn.createStatement();
            System.out.println("coucou je me suis aprés le statment");
            String sql = "SELECT * FROM artiste WHERE email='"+email+"' AND password='"+password+"'";
            System.out.println("coucou je me suis aprés le SELECT");
            ResultSet resultSet = stm.executeQuery(sql);
            System.out.println("coucou je me suis aprés l'execution de la requete");

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
            loginView lgview = new loginView();
            lgview.initialize();
        }

    }
