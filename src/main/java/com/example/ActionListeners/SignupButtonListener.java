package com.example.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.View.HomePageView;
import com.example.View.SignupView;

public class SignupButtonListener implements ActionListener {
    private final HomePageView homePageView;

    public SignupButtonListener(HomePageView homePageView) {
        this.homePageView = homePageView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        homePageView.setVisible(false);

        SignupView suView = new SignupView();

        homePageView.setContentPane(suView);
        
        homePageView.pack();
        homePageView.setVisible(true);
    }
}