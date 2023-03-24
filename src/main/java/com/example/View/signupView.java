package com.example.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.Model.Artiste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.ActionListener.LoginButtonListener;
import com.example.Form.SignupForm;

public class SignupView extends JFrame {
    
    protected static final Component SignupForm = null;
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

                SignupForm suForm = new SignupForm();

                Artiste artiste = suForm.createAccount(firstName, lastName, username, image, password, email, address, telNumber);

                if (artiste != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.init(artiste);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(SignupForm,
                    "Invalid email or password",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel formPanel = new JPanel();
        lbSignupForm.setFont(new Font("Trebuchet MS", Font.BOLD, 40));

        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.insets = new Insets(5, 5, 5, 5);
        
        // Première colonne
        gbcForm.gridx = 0;
        gbcForm.gridwidth = 2;
        gbcForm.gridy = 0;
        formPanel.add(lbSignupForm, gbcForm);
        
        gbcForm.gridwidth = 1;
        gbcForm.anchor = GridBagConstraints.EAST;

        gbcForm.gridy = 1;
        formPanel.add(lbFirstName, gbcForm);
        
        gbcForm.gridy = 2;
        formPanel.add(lbLastName, gbcForm);
        
        gbcForm.gridy = 3;
        formPanel.add(lbUsername, gbcForm);
        
        gbcForm.gridy = 4;
        formPanel.add(lbEmail, gbcForm);
        
        gbcForm.gridy = 5;
        formPanel.add(lbAddress, gbcForm);
        
        gbcForm.gridy = 6;
        formPanel.add(lbTelNumber, gbcForm);
        
        gbcForm.gridy = 7;
        formPanel.add(lbPassword, gbcForm);
        
        gbcForm.gridy = 8;
        formPanel.add(lbConfirmPassword, gbcForm);
        
        // Deuxième colonne
        gbcForm.anchor = GridBagConstraints.WEST;
        gbcForm.gridx = 1;
        
        gbcForm.gridy = 1;
        formPanel.add(tfFirstName, gbcForm);
        tfFirstName.setPreferredSize(new Dimension(300,60));
        
        gbcForm.gridy = 2;
        formPanel.add(tfLastName, gbcForm);
        tfLastName.setPreferredSize(new Dimension(300,60));

        gbcForm.gridy = 3;
        formPanel.add(tfUsername, gbcForm);
        tfUsername.setPreferredSize(new Dimension(300,60));

        gbcForm.gridy = 4;
        formPanel.add(tfEmail, gbcForm);
        tfEmail.setPreferredSize(new Dimension(300,60));

        gbcForm.gridy = 5;
        formPanel.add(tfAddress, gbcForm);
        tfAddress.setPreferredSize(new Dimension(300,60));
        gbcForm.gridy = 6;
        formPanel.add(tfTelNumber, gbcForm);
        tfTelNumber.setPreferredSize(new Dimension(300,60));

        gbcForm.gridy = 7;
        formPanel.add(pfPassword, gbcForm);
        pfPassword.setPreferredSize(new Dimension(300,60));

        gbcForm.gridy = 8;
        formPanel.add(pfConfirmPassword, gbcForm);
        pfConfirmPassword.setPreferredSize(new Dimension(300,60));

        add(formPanel, BorderLayout.NORTH);

        JLabel lbRedirectionSignIn = new JLabel("You already have an account ?");
        JButton btnRedirectionSignIn = new JButton("Login");
        btnRedirectionSignIn.setPreferredSize(new Dimension(100,50));

        btnRedirectionSignIn.addActionListener(new LoginButtonListener(this));

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
        setMinimumSize(new Dimension(600, 930));
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
