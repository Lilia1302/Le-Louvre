package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class LoginForm extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;
    public void initialize() {

        /*Create the forme */
        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbLoginEmail = new JLabel("Email");
        lbLoginEmail.setFont(mainFont);
        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbLoginPassword = new JLabel("Password");
        lbLoginPassword.setFont(mainFont);
        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.add(lbLoginForm);
        formPanel.add(lbLoginEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbLoginPassword);
        formPanel.add(pfPassword);

        /*Create the buttons */
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                Artiste artiste = getAuthentificatedUser(email,password);

                if (artiste != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.init();
                }
            }
            
        });


        add(formPanel, BorderLayout.NORTH);


        setTitle("LogIn Form");
        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private Artiste getAuthentificatedUser(String email, String password){
        Artiste artiste = null;
        final String DB_URL ="jdbc:mysql://localhost/Le_Louvre?serverTimeZone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
         
        try {
            Connection conn =  DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }

            preparedStatement.close();
            conn.close();

        }catch(Exception e){
            System.out.println("Database connexion failed!");
        }
        return artiste;
        }

    }
    

