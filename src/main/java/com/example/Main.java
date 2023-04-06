package com.example;

import javax.swing.*;

import com.example.Controller.LoginController;
import com.example.Model.DatabaseUtil;
import com.example.View.LoginView;


public class Main {
    public static void main(String[] args) {
        // Création de l'objet DataUtils
        DatabaseUtil dataUtils = new DatabaseUtil();

        // Création de l'objet SignupView
        LoginView loginView= new LoginView();

        // Création de l'objet SignupController
        LoginController loginController = new LoginController(loginView, dataUtils);

        // Affichage de la vue
        //loginView.display();
    }
}

