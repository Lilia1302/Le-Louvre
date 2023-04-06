package com.example.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.View.LoginView;
import com.example.View.SignupView;

public class LoginButtonListener implements ActionListener {
    private SignupView signupView;

    public LoginButtonListener(SignupView signupView) {
        this.signupView = signupView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        signupView.setVisible(false);

        LoginView loginView = new LoginView();
        loginView.initialize();

        signupView.setContentPane(loginView);

        signupView.pack();
        signupView.setVisible(true);
    }
}