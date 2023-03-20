package com.example.Model;


import java.sql.*;
import javax.swing.*;
import com.example.View.signupView;

public class SignupForm extends JFrame {
    Connection conn;
    DBConnection dbConnection;

    public Artiste createAccount(String firstName, String lastName, String username, String image, String password, String email, String address, String telNumber){
        Artiste artiste = null;
         
        try {
            dbConnection = new DBConnection();
            conn= dbConnection.init(conn);
             // Connected to database successfully...

            Statement stm = conn.createStatement();

            String sql = "INSERT INTO Artist(firstName, lastName, username, image, email, address, telNumber, password) VALUES ('" + firstName + "','" + lastName + "','" + username + "','image','" + email + "','" + address +"','" + telNumber + "','" + password +"')";

            int result = stm.executeUpdate(sql);

			if (result == 1) {
                JOptionPane.showMessageDialog(null, "Your account was successfully created.");
			}

            String sql2 = "SELECT * FROM Artist where username='" + username + "'";

            ResultSet resultSet = stm.executeQuery(sql2);

            if (resultSet.next()) {    
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                username = resultSet.getString("username");
                image = resultSet.getString("image");
                email = resultSet.getString("email");
                address = resultSet.getString("address");
                telNumber = resultSet.getString("telNumber");
                password = resultSet.getString("password");
                artiste = new Artiste(firstName, lastName, username, image, email, telNumber, address, password);
            }

            stm.close();
            conn.close();

        } catch(Exception e){
            System.out.println("Database connexion failed!");
            e.printStackTrace();
        }
        return artiste;
    }

    public static void main(String[] args) {

       signupView suview = new signupView();
        suview.initialize();
    }

}