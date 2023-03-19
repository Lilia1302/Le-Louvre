package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignupForm extends JFrame {

    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);
    JTextField tfFirstName;
    JTextField tfLastName;
    JTextField tfUsername;
    JTextField tfEmail;
    JTextField tfAddress;
    JTextField tfTelNumber;
    JPasswordField pfPassword;
    JPasswordField pfConfirmPassword;

    public void initialize() {

        /*Create the form */
        JLabel lbSignupForm = new JLabel("Sign up", SwingConstants.CENTER);
        lbSignupForm.setBorder(new EmptyBorder(10, 0, 10, 0));
        lbSignupForm.setFont(mainFont);

        JLabel lbFirstName = new JLabel("First name", SwingConstants.CENTER);
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last name", SwingConstants.CENTER);
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JLabel lbUsername = new JLabel("Username", SwingConstants.CENTER);
        lbUsername.setFont(mainFont);

        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        JLabel lbEmail = new JLabel("Email", SwingConstants.CENTER);
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbTelNumber = new JLabel("Phone", SwingConstants.CENTER);
        lbTelNumber.setFont(mainFont);

        tfTelNumber = new JTextField();
        tfTelNumber.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password", SwingConstants.CENTER);
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JLabel lbConfirmPassword = new JLabel("Confirm Password", SwingConstants.CENTER);
        lbConfirmPassword.setFont(mainFont);

        pfConfirmPassword = new JPasswordField();
        pfConfirmPassword.setFont(mainFont);

        JLabel lbAddress = new JLabel("Address", SwingConstants.CENTER);
        lbAddress.setFont(mainFont);

        tfAddress = new JTextField();
        tfAddress.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        /*Create the button */
        JButton btnSignup = new JButton("Sign up");
        btnSignup.setBackground(Color.orange);
        btnSignup.setOpaque(true);
        btnSignup.setBorderPainted(false);
        btnSignup.setFont(mainFont);
        btnSignup.setPreferredSize(new Dimension(400,80));

        btnSignup.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                String username = tfUsername.getText();
                String image = "image";
                String password = String.valueOf(pfPassword.getPassword());
                String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());
                String email = tfEmail.getText();
                String telNumber = tfTelNumber.getText();
                String address = tfAddress.getText();

                Artiste artiste = createAccount(firstName, lastName, username, image, password, email, address, telNumber);

                if (artiste != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.init(artiste);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(SignupForm.this,
                    "Invalid email or password",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel formPanel = new JPanel();
        lbSignupForm.setFont(new Font("Trebuchet MS", Font.BOLD, 2));

        formPanel.setLayout(new GridLayout(0,1,0,0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbSignupForm);
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbAddress);
        formPanel.add(tfAddress);
        formPanel.add(lbTelNumber);
        formPanel.add(tfTelNumber);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.add(lbConfirmPassword);
        formPanel.add(pfConfirmPassword);

        add(formPanel, BorderLayout.NORTH);

        JLabel lbRedirectionSignIn = new JLabel("You already have an account ?");
        JButton btnRedirectionSignIn = new JButton("Sign in");
        btnRedirectionSignIn.setPreferredSize(new Dimension(100,50));

        btnRedirectionSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupForm().setVisible(false);
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(btnSignup, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(30, 50, 50, 0);
        buttonsPanel.add(lbRedirectionSignIn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(30, 0, 50, 50);
        buttonsPanel.add(btnRedirectionSignIn, gbc);

        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Sign up");
        setSize(480, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 1000));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Artiste createAccount(String firstName, String lastName, String username, String image, String password, String email, String address, String telNumber){
        Artiste artiste = null;

        final String DB_URL ="jdbc:mysql://localhost:3306/Le_Louvre";
        final String USERNAME = "root";
        final String PASSWORD = "root";
         
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

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

        SignupForm signupForm = new SignupForm();
        signupForm.initialize();
    }

}