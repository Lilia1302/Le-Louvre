package com.example;

import com.example.Controller.HomePageController;
import com.example.Controller.LoginController;
import com.example.Model.DatabaseUtil;
import com.example.View.HomePageView;
import com.example.View.LoginView;


public class Main {
    public static void main(String[] args) {
        // Création de l'objet DataUtils
        DatabaseUtil dataUtils = new DatabaseUtil();

        // Création de l'objet SignupView
       HomePageView homePageView = new HomePageView();

        // Création de l'objet SignupController
       HomePageController homePageController = new HomePageController(homePageView);
        homePageView.show();
    }
}

