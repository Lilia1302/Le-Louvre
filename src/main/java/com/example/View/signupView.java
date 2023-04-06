package com.example.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.example.Controller.SignupController;
import com.example.Form.SignupForm;
import com.example.Interface.ISignupView;

public class SignupView extends JFrame implements ISignupView {

    private SignupController signupController;

    private final Font mainFont;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField telNumberField;
    private JPasswordField passwordField;
    private JButton createAccountButton;

    public SignupView() {

        mainFont = new Font("Avenir", Font.BOLD, 18);

        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 930));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lbSignupForm = new JLabel("Sign up");
        lbSignupForm.setFont(new Font("Trebuchet MS", Font.BOLD, 40));

        firstNameField = new JTextField(20);
        firstNameField.setFont(mainFont);
        firstNameField.setPreferredSize(new Dimension(100,60));

        lastNameField = new JTextField(20);
        lastNameField.setFont(mainFont);
        lastNameField.setPreferredSize(new Dimension(100,60));

        usernameField = new JTextField(20);
        usernameField.setFont(mainFont);
        usernameField.setPreferredSize(new Dimension(100,60));

        emailField = new JTextField(20);
        emailField.setFont(mainFont);
        emailField.setPreferredSize(new Dimension(100,60));

        addressField = new JTextField(20);
        addressField.setFont(mainFont);
        addressField.setPreferredSize(new Dimension(100,60));


        telNumberField = new JTextField(20);
        telNumberField.setFont(mainFont);
        telNumberField.setPreferredSize(new Dimension(100,60));

        passwordField = new JPasswordField(20);
        passwordField.setFont(mainFont);
        passwordField.setPreferredSize(new Dimension(100,60));

        createAccountButton = new JButton("Create your account");
        createAccountButton.setBackground(Color.orange);
        createAccountButton.setPreferredSize(new Dimension(400,80));
        createAccountButton.setOpaque(true);
        createAccountButton.setBorderPainted(false);
        createAccountButton.setFont(mainFont);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String address = addressField.getText();
                String telNumber = telNumberField.getText();
                String password = new String(passwordField.getPassword());
                signupController.signupButtonClicked(firstName, lastName, username, password, email, address, telNumber);
            }
        });

        JLabel lbRedirectionSignIn = new JLabel("You already have an account ?");
        JButton btnRedirectionSignIn = new JButton("Login");
        btnRedirectionSignIn.setPreferredSize(new Dimension(100,50));

        btnRedirectionSignIn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                signupController.redirectToLogin();
            }
        });
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lbSignupForm, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(new JLabel("First Name") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Last Name") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Email") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Address") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Phone number") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(telNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Username") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Password") {
            {
                setFont(mainFont);
            }
        }, gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.insets = new Insets(30, 10, 10, 10);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 8;
        add(createAccountButton, gbc);

        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(lbRedirectionSignIn, gbc);
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(btnRedirectionSignIn, gbc);

        pack();
        setVisible(true);
    }

    @Override
    public void setController(SignupController signupController) {
        this.signupController = signupController;
    }

    @Override
    public void display() {
        // Afficher la vue
        setVisible(true);
    }

    @Override
    public void close() {
        // Fermer la vue
        setVisible(false);
    }

    @Override
    public void showError(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showError'");
    }

    @Override
    public void showSuccess(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSuccess'");
    }

    @Override
    public SignupForm getSignupForm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSignupForm'");
    }

    @Override
    public void clearFields() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearFields'");
    }
}