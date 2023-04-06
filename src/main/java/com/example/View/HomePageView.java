package com.example.View;
import javax.swing.*;

import com.example.ActionListeners.SignupButtonListener;
import com.example.View.BackgroundImages.BGIHomePage;

import java.awt.*;

public class HomePageView extends JFrame{
    public HomePageView() {

        super("Page d'accueil - Le Louvre");

        JPanel root = new JPanel(new BorderLayout());

        // Create navbar
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navBar.setBackground(Color.PINK);
        Dimension navBarSize = new Dimension(navBar.getPreferredSize().width, 70);
        navBar.setPreferredSize(navBarSize);

        // Create buttons
        final JButton inscriptionBtn = new JButton("Inscription");
        inscriptionBtn.setForeground(Color.BLACK);
        JButton galerieBtn = new JButton("Galerie");
        galerieBtn.setForeground(Color.BLACK);
        JButton evenementsBtn = new JButton("Événements");
        evenementsBtn.setForeground(Color.BLACK);

        // Add action listeners
        inscriptionBtn.addActionListener(new SignupButtonListener(this));

        //galerieBtn.addActionListener(this);
        //evenementsBtn.addActionListener(this);

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

}
