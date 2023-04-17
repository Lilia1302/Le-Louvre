package com.example.View;

import javax.swing.*;
import java.util.List;

import com.example.Controller.GalleryController;
import com.example.Interface.IGalleryView;
import com.example.Model.Oeuvre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GalleryView implements IGalleryView {
    private JFrame frame;
    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);
    private JButton btnAjouter;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JTextField textFieldTitle;
    private JTextField textFieldArtist;
    private JTextField textFieldEstimatedPrice;
    private JTextField textFieldType;
    private JTextField textFieldDimension;
    private GalleryController galleryController;
    List<Oeuvre> oeuvres;

    public GalleryView() {
        frame = new JFrame("Galerie");
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(800, 900);
        buttonPanel.setLayout(new GridLayout(0, 2)); // Utiliser un GridLayout avec 1 colonne pour les boutons

        textFieldTitle = new JTextField();
        textFieldTitle.setFont(mainFont);
        buttonPanel.add(new JLabel("Titre") {
            {
            setFont(mainFont);
            }
        });
        buttonPanel.add(textFieldTitle);

        textFieldArtist = new JTextField();
        textFieldArtist.setFont(mainFont);
        buttonPanel.add(new JLabel("Artiste") {
            {
            setFont(mainFont);
            }
        });
        buttonPanel.add(textFieldArtist);

        textFieldEstimatedPrice = new JTextField();
        textFieldEstimatedPrice.setFont(mainFont);
        buttonPanel.add(new JLabel("Prix estimé") {
            {
            setFont(mainFont);
            }
        });
        buttonPanel.add(textFieldEstimatedPrice);

        textFieldType = new JTextField();
        textFieldType.setFont(mainFont);
        buttonPanel.add(new JLabel("Type") {
            {
            setFont(mainFont);
            }
        });
        buttonPanel.add(textFieldType);

        textFieldDimension = new JTextField();
        textFieldDimension.setFont(mainFont);
        buttonPanel.add(new JLabel("Dimension") {
            {
            setFont(mainFont);
            }
        });
        buttonPanel.add(textFieldDimension);

        // Bouton Ajouter
        btnAjouter = new JButton("Ajouter");
        btnAjouter.setFont(mainFont);

        // Exemple d'écouteur d'événement pour le bouton Ajouter
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les informations de la nouvelle oeuvre à partir des champs de saisie dans GalleryView
                String title = textFieldTitle.getText();
                String artist = textFieldArtist.getText();
                double estimatedPrice = Double.parseDouble(textFieldEstimatedPrice.getText());
                String type = textFieldType.getText();
                String dimension = textFieldDimension.getText();
                
                // Créer un nouvel objet Oeuvre
                Oeuvre nouvelleOeuvre = new Oeuvre(title, artist, estimatedPrice, type, dimension);
                
                // Appeler la méthode create du GalleryController pour ajouter la nouvelle oeuvre
                galleryController.create(nouvelleOeuvre);
            }
        });
        buttonPanel.add(btnAjouter);

        // Bouton Modifier
        btnModifier = new JButton("Modifier");
        btnModifier.setFont(mainFont);

        // Exemple d'écouteur d'événement pour le bouton Modifier
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les informations de l'oeuvre à modifier à partir des champs de saisie dans GalleryView
                String title = textFieldTitle.getText();
                String artist = textFieldArtist.getText();
                double estimatedPrice = Double.parseDouble(textFieldEstimatedPrice.getText());
                String type = textFieldType.getText();
                String dimension = textFieldDimension.getText();
                
                // Récupérer l'objet Oeuvre correspondant à partir du GalleryController
                Oeuvre oeuvreAModifier = galleryController.getOeuvreByTitle(title);
                
                // Mettre à jour les propriétés de l'objet Oeuvre
                oeuvreAModifier.setArtist(artist);
                oeuvreAModifier.setEstimatedPrice(estimatedPrice);
                oeuvreAModifier.setType(type);
                oeuvreAModifier.setDimension(dimension);
                
                // Appeler la méthode update du GalleryController pour modifier l'oeuvre
                galleryController.update(oeuvreAModifier);
            }
        });
        buttonPanel.add(btnModifier);

        // Bouton Supprimer
        btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setFont(mainFont);

        // Exemple d'écouteur d'événement pour le bouton Supprimer
        btnSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer le titre de l'oeuvre à supprimer à partir du champ de saisie dans GalleryView
                String title = textFieldTitle.getText();

                // Appeler la méthode delete du GalleryController pour supprimer l'oeuvre
                galleryController.delete(title);
            }
        });
        buttonPanel.add(btnSupprimer);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void setController(GalleryController galleryController) {
        this.galleryController = galleryController;
    }

    @Override
    public void display() {
        // Afficher la vue
        frame.setVisible(true);
    }

    @Override
    public void close() {
        // Fermer la vue
        frame.dispose();
    }

    // Getters pour les boutons
    public JButton getBtnAjouter() {
        return btnAjouter;
    }

    public JButton getBtnModifier() {
        return btnModifier;
    }

    public JButton getBtnSupprimer() {
        return btnSupprimer;
    }

    // Méthode pour afficher les œuvres dans l'interface utilisateur
    @Override
    public List<Oeuvre> afficherOeuvres(List<Oeuvre> oeuvres) {
        List<Oeuvre> allOeuvres = galleryController.getAllOeuvres(); // Appeler la méthode pour récupérer les œuvres de la base de données
        this.afficherOeuvres(allOeuvres);
        return oeuvres;
    }
    

    public static void main(String[] args) {
        new GalleryView();
    }
}