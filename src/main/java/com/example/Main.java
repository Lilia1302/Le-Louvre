package com.example;

import com.example.Controller.HomePageController;
import com.example.Controller.LoginController;
import com.example.Controller.ProfilController;
import com.example.Controller.SignupController;
import com.example.Model.DatabaseUtil;
import com.example.View.HomePageView;
import com.example.View.LoginView;
import com.example.View.ProfilView;
import com.example.View.SignupView;


public class Main {
    public static void main(String[] args) {
        // Création des différentes instances nécessaires
        DatabaseUtil databaseUtil = new DatabaseUtil();
        HomePageView homePageView = new HomePageView();
        LoginView loginView = new LoginView();
        SignupView inscriptionView = new SignupView();
        ProfilView profilView = new ProfilView();
        HomePageController homePageController = new HomePageController(homePageView);
        LoginController loginController = new LoginController(loginView, databaseUtil);
        SignupController inscriptionController = new SignupController(inscriptionView, databaseUtil);
        ProfilController profilController = new ProfilController(profilView, databaseUtil);

        // Configuration des contrôleurs avec leurs vues respectives
       
        loginView.setController(loginController);
        inscriptionView.setController(inscriptionController);
        profilView.setController(profilController);

        // Affichage de la page d'accueil
        homePageView.show();
    }
}

