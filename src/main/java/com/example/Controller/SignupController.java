package com.example.Controller;

import com.example.Form.SignupForm;
import com.example.Interface.ISignupController;
import com.example.Interface.ISignupView;
import com.example.Model.DatabaseUtil;
import com.example.View.LoginView;
import com.example.View.SignupView;

public class SignupController implements ISignupController {
    private SignupView signupView;
    private DatabaseUtil databaseUtil;

    public SignupController(SignupView signupView, DatabaseUtil databaseUtil) {
        this.signupView = signupView;
        this.databaseUtil = databaseUtil;
        this.signupView.setController(this);
    }

    @Override
    public void signupButtonClicked(String firstName, String lastName, String username, String password, String email, String address, String telNumber) {
        if (username.isEmpty() || password.isEmpty()) {
            signupView.showError("Please enter both username and password.");
        } else {
            boolean success = databaseUtil.addUser(firstName,lastName,username,password,email,address,telNumber);
            if (success) {
                signupView.showSuccess("User created successfully!");
            } else {
                signupView.showError("Failed to create user.");
            }
        }
    }

    @Override
    public void createAccount(SignupForm signupForm) {
        String username = signupForm.getUsername();
        String password = signupForm.getPassword();
        String firstName = signupForm.getFirstName();
        String lastName = signupForm.getLastName();
        String email = signupForm.getEmail();
        String address = signupForm.getAddress();
        String telNumber = signupForm.getTelNumber();
        signupButtonClicked(firstName, lastName, username, password, email, address, telNumber);
    }

    @Override
    public void setView(ISignupView view) {
        this.signupView.setController(this);
    }

    public void redirectToLogin() {
        LoginView loginView = new LoginView();
        loginView.display();
        this.signupView.setVisible(false);
    }
}



