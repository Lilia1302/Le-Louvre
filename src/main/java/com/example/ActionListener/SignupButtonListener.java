package com.example.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.View.LoginView;
import com.example.View.SignupView;

public class SignupButtonListener implements ActionListener {
    private LoginView loginView;

    public SignupButtonListener(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginView.setVisible(false);

        SignupView signupView = new SignupView();
        signupView.initialize();

        loginView.setContentPane(signupView);

        loginView.pack();
        loginView.setVisible(true);
    }
}