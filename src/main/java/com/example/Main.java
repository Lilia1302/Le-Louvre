package com.example;

import com.example.Controller.HomePageController;

import com.example.Model.DatabaseUtil;
import com.example.View.HomePageView;


public class Main {
    public static void main(String[] args) {
        // Création des différentes instances nécessaires
        DatabaseUtil databaseUtil = new DatabaseUtil();
        HomePageView homePageView = new HomePageView();
        HomePageController homePageController = new HomePageController(homePageView);
        
        // Configuration des contrôleurs avec leurs vues respectives
       
      

        // Affichage de la page d'accueil
        homePageView.show();
    }
}

