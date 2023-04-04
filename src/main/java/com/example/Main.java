package com.example;

import javax.swing.*;

import com.example.Controller.SignupController;
import com.example.Model.DatabaseUtil;
import com.example.View.SignupView;

public class Main {
    public static void main(String[] args) {
        // Création de l'objet DataUtils
        DatabaseUtil dataUtils = new DatabaseUtil();

        // Création de l'objet SignupView
        SignupView signupView = new SignupView();

        // Création de l'objet SignupController
        SignupController signupController = new SignupController(signupView, dataUtils);

        // Affichage de la vue
        signupView.display();
    }
}

