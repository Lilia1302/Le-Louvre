package com.example.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.Interface.IDatabaseUtil;

public class DatabaseUtil implements IDatabaseUtil {
    private DBConnection dbConnection;
    private Artiste artiste;

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
            String sql = "SELECT * FROM artiste WHERE email='" + email + "' AND password='" + password + "'";
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
    public Artiste getUserByEmail(String email) {
        Artiste artiste = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
    
        try {
            conn = dbConnection.init(conn);
            String sql = "SELECT * FROM artiste WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
    
            if (rs.next()) {
                artiste = new Artiste(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("username"),
                    rs.getString("image"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("telNumber"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }
    
        return artiste;
    }
    

    @Override
    public boolean emailExists(String email) {
        // Code pour vérifier si une adresse email existe déjà dans la base de données
        return false;
    }

    
    

    @Override
    public Artiste getCurrentUser(){
        try {
            Connection conn = dbConnection.init(null);
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM artiste WHERE firstName = " + artiste.getFirstName();
            ResultSet resultSet = stm.executeQuery(sql);

            if (resultSet.next()) {
                        artiste = new Artiste(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("username"),
                        resultSet.getString("image"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("telNumber"),
                        resultSet.getString("password")
                );
                return artiste;
            }
        } catch (SQLException e) {
            System.out.println("Failed to get current user from database: " + e.getMessage());
        }
        return null;
    }
    @Override
    public void setCurrentUser(Artiste artiste) {
        this.artiste = artiste;
    }
    

    @Override
    public boolean create(Oeuvre oeuvre) {
        Connection conn = dbConnection.init(null);
        try {
            // Préparer la requête SQL
            String query = "INSERT INTO oeuvre (title, artist, estimated_price, type, dimension) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, oeuvre.getTitle());
            preparedStatement.setString(2, oeuvre.getArtist());
            preparedStatement.setDouble(3, oeuvre.getEstimatedPrice());
            preparedStatement.setString(4, oeuvre.getType());
            preparedStatement.setString(5, oeuvre.getDimension());

            // Exécuter la requête SQL
            preparedStatement.executeUpdate();
            System.out.println("Œuvre ajoutée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Oeuvre read(String title) {
        Connection conn = dbConnection.init(null);
        Oeuvre oeuvre = null;
        try {
            String query = "SELECT * FROM oeuvre WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String artist = resultSet.getString("artist");
                double estimatedPrice = resultSet.getDouble("estimated_price");
                String type = resultSet.getString("type");
                String dimension = resultSet.getString("dimension");
                oeuvre = new Oeuvre(title, artist, estimatedPrice, type, dimension);
            } else {
                System.out.println("Œuvre introuvable !");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oeuvre;
    }

    @Override
    public boolean update(Oeuvre oeuvre) {
        Connection conn = dbConnection.init(null);
        try {
            String query = "UPDATE oeuvre SET artist = ?, estimated_price = ?, type = ?, dimension = ? WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, oeuvre.getArtist());
            preparedStatement.setDouble(2, oeuvre.getEstimatedPrice());
            preparedStatement.setString(3, oeuvre.getType());
            preparedStatement.setString(4, oeuvre.getDimension());
            preparedStatement.setString(5, oeuvre.getTitle());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Œuvre mise à jour avec succès !");
            } else {
                System.out.println("Échec de la mise à jour de l'œuvre !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String title) {
        Connection conn = dbConnection.init(null);
        try {
            String query = "DELETE FROM oeuvre WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, title);
    
            int rowsAffected = preparedStatement.executeUpdate();
    
            if (rowsAffected > 0) {
                System.out.println("Œuvre supprimée avec succès !");
            } else {
                System.out.println("Échec de la suppression de l'œuvre !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Oeuvre> getAllOeuvres() {
        List<Oeuvre> oeuvres = new ArrayList<>();
        Connection conn = dbConnection.init(null);

        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM oeuvre";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                double estimatedPrice = rs.getDouble("estimated_price");
                String type = rs.getString("type");
                String dimension = rs.getString("dimension");

                Oeuvre oeuvre = new Oeuvre(title, artist, estimatedPrice, type, dimension);
                oeuvres.add(oeuvre);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch oeuvres from database: " + e.getMessage());
        }
        return oeuvres;
    }

    public Oeuvre getOeuvreByTitle(String title) {
        Oeuvre oeuvre = null;
        Connection conn = dbConnection.init(null);
        try {
            String sql = "SELECT * FROM oeuvre WHERE title = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, title);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String artist = rs.getString("artist");
                double estimatedPrice = rs.getDouble("estimated_price");
                String type = rs.getString("type");
                String dimension = rs.getString("dimension");

                oeuvre = new Oeuvre(title, artist, estimatedPrice, type, dimension);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch oeuvre from database: " + e.getMessage());
        }
        return oeuvre;
    }
}

