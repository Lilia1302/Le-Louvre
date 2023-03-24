package com.example.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.example.View.HomePageView;
import com.example.View.signupView;

public class InscriptionButtonListener implements ActionListener {
    private final HomePageView homePageView;

    public InscriptionButtonListener(HomePageView homePageView) {
        this.homePageView = homePageView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        homePageView.setVisible(false);

        signupView suView = new signupView();
        suView.initialize();

        homePageView.setContentPane(suView);
        
        homePageView.pack();
        homePageView.setVisible(true);
    }
}