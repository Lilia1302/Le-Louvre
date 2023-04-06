package com.example.Controller;

import com.example.Form.LoginForm;
import com.example.Interface.IDatabaseUtil;
import com.example.Interface.ILoginController;
import com.example.Interface.ILoginView;
import com.example.Model.DatabaseUtil;
import com.example.View.LoginView;

public class LoginController implements ILoginController {

        private LoginView view;
        private final DatabaseUtil databaseUtil;

    public LoginController(LoginView loginView, DatabaseUtil databaseUtil) {
        this.view = loginView;
        this.databaseUtil = databaseUtil;
        this.view.setController(this);
    }

    @Override
    public void loginButtonClicked(String email,String password) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showError("Please enter both username and password.");
        } else {
            boolean success = databaseUtil.userExists(email,password);
            if (success) {
                view.showSuccessMessage("User connected successfully!");
            } else {
                view.showError("Failed to connect user.");
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
    public void setView(LoginView view) {
        this.view = view;
        this.view.setController(this);
    }
}
    

