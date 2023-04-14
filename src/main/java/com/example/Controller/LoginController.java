package com.example.Controller;

import com.example.Form.LoginForm;
import com.example.Interface.ILoginController;
import com.example.Model.DatabaseUtil;
import com.example.View.LoginView;
import com.example.View.SignupView;

public class LoginController implements ILoginController {

        private LoginView loginView;
        private final DatabaseUtil databaseUtil;

    public LoginController(LoginView loginView, DatabaseUtil databaseUtil) {
        this.loginView = loginView;
        this.databaseUtil = databaseUtil;
        this.loginView.setController(this);
    }

    @Override
    public void loginButtonClicked(String email,String password) {
        if (email.isEmpty() || password.isEmpty()) {
            loginView.showError("Please enter both username and password.");
        } else {
            boolean success = databaseUtil.userExists(email,password);
            if (success) {
                loginView.showSuccessMessage("User connected successfully!");
            } else {
                loginView.showError("Failed to connect user.");
            }
        }
    }

    @Override
    public void login(LoginForm loginForm) {
        String password = loginForm.getPassword();
       
        String email = loginForm.getEmail();
       
        loginButtonClicked(email, password);
    }

    @Override
    public void setView(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.setController(this);
    }

    public void redirectToSignup() {
        SignupView signupView = new SignupView();
        signupView.display();
        loginView.setVisible(false);
    }
}
    

