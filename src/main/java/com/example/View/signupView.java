package com.example.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.example.Controller.SignupController;
import com.example.Form.SignupForm;
import com.example.Interface.ISignupController;
import com.example.Interface.ISignupView;



public class SignupView extends JFrame implements ISignupView {

    private SignupController signupController;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField telNumberField;
    private JPasswordField passwordField;
    private JButton createAccountButton;

    public SignupView() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        addressField = new JTextField(20);
        telNumberField = new JTextField(20);
        passwordField = new JPasswordField(20);
        createAccountButton = new JButton("Create Account");

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

        add(new JLabel("First Name: "));
        add(firstNameField);
        add(new JLabel("Last Name: "));
        add(lastNameField);
        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Email: "));
        add(emailField);
        add(new JLabel("Address: "));
        add(addressField);
        add(new JLabel("Tel Number: "));
        add(telNumberField);
        add(new JLabel("Password: "));
        add(passwordField);
        add(createAccountButton);

        pack();
        setVisible(true);
    }

    @Override
    public void setController(SignupController controller) {
        this.signupController = controller;
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