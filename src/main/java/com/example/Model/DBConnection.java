package com.example.Model;
import java.sql.*;
public class DBConnection {
    final String DB_URL ="jdbc:mysql://localhost:3306/le_louvre";
    final String USERNAME = "root";
    final String PASSWORD = "";
      
    public Connection init(Connection conn){
        try {
         conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        
        }catch(Exception e){
            System.out.println("Database connexion failed!");
        }
        return conn;
        
    }
}
