package com.example.View;
import javax.swing.*;

import com.example.Form.SignupForm;
import com.example.View.BackgroundImages.BGIHomePage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageView extends JFrame implements ActionListener {
    public HomePageView() {

        super("Page d'accueil - Le Louvre");

        JPanel root = new JPanel(new BorderLayout());

        // Create navbar
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navBar.setBackground(Color.PINK);
        Dimension navBarSize = new Dimension(navBar.getPreferredSize().width, 70);
        navBar.setPreferredSize(navBarSize);

        // Create buttons
        JButton inscriptionBtn = new JButton("Connexion");
        inscriptionBtn.setForeground(Color.BLACK);
        JButton galerieBtn = new JButton("Galerie");
        galerieBtn.setForeground(Color.BLACK);
        JButton evenementsBtn = new JButton("Événements");
        evenementsBtn.setForeground(Color.BLACK);

        // Add action listeners
        inscriptionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomePageView().setVisible(false);
                signupView suView = new signupView();
                suView.setVisible(true);
            }
        });
        galerieBtn.addActionListener(this);
        evenementsBtn.addActionListener(this);

        // Add buttons to the navbar
        navBar.add(inscriptionBtn);
        navBar.add(galerieBtn);
        navBar.add(evenementsBtn);

    
        

        // Add image
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        BGIHomePage backgroundImage = new BGIHomePage("C:/Users/ULTRABOOK DELL/OneDrive - UPEC/Bureau/demo/src/main/java/com/example/View/Images/Pyramide.jpeg");

        backgroundPanel.add(backgroundImage, BorderLayout.CENTER);
        root.add(navBar, BorderLayout.NORTH);
        root.add(backgroundPanel, BorderLayout.CENTER);

       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(root);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*public void actionPerformed(ActionEvent e) {
        // Réagir aux événements des boutons de la barre de navigation ici
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HomePageView();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
