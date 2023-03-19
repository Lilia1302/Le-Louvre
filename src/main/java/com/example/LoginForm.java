package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame {

    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;

    public void initialize() {

        /*Create the form */
        JLabel lbLoginForm = new JLabel("Login", SwingConstants.CENTER);
        lbLoginForm.setBorder(new EmptyBorder(10, 0, 10, 0));
        lbLoginForm.setFont(mainFont);

        JLabel lbLoginEmail = new JLabel("Email", SwingConstants.CENTER);
        lbLoginEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbLoginPassword = new JLabel("Password", SwingConstants.CENTER);
        lbLoginPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        lbLoginForm.setFont(new Font("Trebuchet MS", Font.BOLD, 40));

        formPanel.setLayout(new GridLayout(0,1,0,0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbLoginEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbLoginPassword);
        formPanel.add(pfPassword);

        /*Create the button */
        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.orange);
        btnLogin.setOpaque(true);
        btnLogin.setBorderPainted(false);
        btnLogin.setFont(mainFont);
        btnLogin.setPreferredSize(new Dimension(400,80));

        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                Artiste artiste = getAuthentificatedUser(email, password);

                if (artiste != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.init(artiste);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                    "Invalid email or password",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lbRedirectionSignIn = new JLabel("You don't have an account ?");
        JButton btnRedirectionSignIn = new JButton("Sign in");
        btnRedirectionSignIn.setPreferredSize(new Dimension(100,50));


        btnRedirectionSignIn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm().setVisible(false);
                SignupForm signupForm = new SignupForm();
                signupForm.setVisible(true);
            }
        });


        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(btnLogin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.EAST;
        gbc.insets = new Insets(50, 40, 20, 0);
        buttonsPanel.add(lbRedirectionSignIn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.WEST;
        gbc.insets = new Insets(50, 0, 20, 40);
        buttonsPanel.add(btnRedirectionSignIn, gbc);

        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login");
        setSize(480, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Artiste getAuthentificatedUser(String email, String password){
        Artiste artiste = null;

        final String DB_URL ="jdbc:mysql://localhost:3306/Le_Louvre";
        final String USERNAME = "root";
        final String PASSWORD = "root";
         
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stm = conn.createStatement();

            String sql = "SELECT * FROM Artist WHERE email='"+email+"' AND password='"+password+"'";            

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
    
            LoginForm loginForm = new LoginForm();
            loginForm.initialize();
        }

    }
