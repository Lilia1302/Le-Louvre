package com.example.Interface;

import java.awt.event.ActionListener;

import com.example.Controller.ProfilController;
import com.example.Model.Artiste;

public interface IProfilView {
    void setController(ProfilController controller);
    
    void displayProfilData(Artiste artiste);
    // Méthode pour ajouter un écouteur sur le bouton de déconnexion
    void addEditButtonListener(ActionListener listener);
}

