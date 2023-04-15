package com.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.example.Controller.ProfilController;
import com.example.Interface.IProfilController;
import com.example.Interface.IProfilView;
import com.example.Model.Artiste;

public class ProfilView extends JPanel implements IProfilView {
    private JLabel firstNameLabel, lastNameLabel, emailLabel, addressLabel, telNumberLabel;
    private JTextField firstNameField, lastNameField, emailField, addressField, telNumberField;
    private JButton updateButton, logoutButton;
    private ProfilController controller;

    public ProfilView() {
        setLayout(new GridLayout(6, 2));

        firstNameLabel = new JLabel("Prénom :");
        add(firstNameLabel);
        firstNameField = new JTextField();
        add(firstNameField);

        lastNameLabel = new JLabel("Nom :");
        add(lastNameLabel);
        lastNameField = new JTextField();
        add(lastNameField);

        emailLabel = new JLabel("Email :");
        add(emailLabel);
        emailField = new JTextField();
        add(emailField);

        addressLabel = new JLabel("Adresse :");
        add(addressLabel);
        addressField = new JTextField();
        add(addressField);

        telNumberLabel = new JLabel("Numéro de téléphone :");
        add(telNumberLabel);
        telNumberField = new JTextField();
        add(telNumberField);

        updateButton = new JButton("Mettre à jour le profil");
        add(updateButton);
        logoutButton = new JButton("Déconnexion");
        add(logoutButton);
    }

    @Override
    public void setController(ProfilController controller) {
        this.controller = controller;
        displayProfilData(controller.getCurrentUser());
    }


    @Override
    public void displayProfilData(Artiste artiste) {
        JLabel lblNom = new JLabel("Nom : " + artiste.getLastName());
        JLabel lblPrenom = new JLabel("Prénom : " + artiste.getFirstName());
        JLabel lblEmail = new JLabel("Email : " + artiste.getEmail());
        JLabel lblAdresse = new JLabel("Adresse : " + artiste.getAddress());
        JLabel lblTel = new JLabel("Téléphone : " +artiste.getTelNumber());

        add(lblNom);
        add(lblPrenom);
        add(lblEmail);
        add(lblAdresse);
        add(lblTel);

        revalidate();
        repaint();
    }
}
