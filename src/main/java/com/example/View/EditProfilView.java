package com.example.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import com.example.Model.Artiste;
import com.example.Model.DBConnection;

public class EditProfilView extends JFrame implements ActionListener {
    
        private Artiste artiste; // objet modèle d'utilisateur
        
        private JLabel nameLabel;
        private JTextField nameTextField;
        private JLabel emailLabel;
        private JTextField emailTextField;
        private JButton saveButton;
        Connection conn;
        DBConnection dbConnection;
        
        public EditProfilView(Artiste artiste) {
            this.artiste = artiste;
            
            nameLabel = new JLabel("Name:");
            nameTextField = new JTextField(artiste.getFirstName());
            emailLabel = new JLabel("Email:");
            emailTextField = new JTextField(artiste.getEmail());
            saveButton = new JButton("Save");
            
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Enregistrer les modifications dans la base de données
                    String firstName = nameTextField.getText();
                    String email = emailTextField.getText();
                    try {
                    dbConnection = new DBConnection();
                    conn= dbConnection.init(conn);
                    // Connected to database successfully...
    
                    Statement stm = conn.createStatement();
            
                    String sql = "INSERT INTO artiste(firstName,email) VALUES ('" + firstName + "','" + email +"')";
          
           
                    int result = stm.executeUpdate(sql);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "Your informations have been changed");
                    }
            } catch(Exception e1){
                System.out.println("Database connexion failed!");
                e1.printStackTrace();
            }
            
                    // Fermer la fenêtre d'édition de profil
                    dispose();
                }
            });
            JPanel contentPane = new JPanel();
            contentPane.setLayout(new GridLayout(3, 2));
            contentPane.add(nameLabel);
            contentPane.add(nameTextField);
            contentPane.add(emailLabel);
            contentPane.add(emailTextField);
            contentPane.add(saveButton);
            
            setContentPane(contentPane);
            pack();
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

        public static void main(String[] args) {
           final Artiste artiste = new Artiste("L", "l", "lll", "ull", "nk", "9785l", "KK", "KK");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new EditProfilView(artiste);
                }
            });
        }
    
    }
    

