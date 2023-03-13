package com.example;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public void init (Artiste artiste){
        /*************** Info Panel ***************/
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        infoPanel.add(new JLabel());
        infoPanel.add(new JLabel(artiste.getImage()));
        infoPanel.add(new JLabel("First name"));
        infoPanel.add(new JLabel(artiste.getFirstName()));
        infoPanel.add(new JLabel("Last name"));
        infoPanel.add(new JLabel(artiste.getLastName()));
        infoPanel.add(new JLabel("Username"));
        infoPanel.add(new JLabel(artiste.getUsername()));
        infoPanel.add(new JLabel("Email"));
        infoPanel.add(new JLabel(artiste.getEmail()));
        infoPanel.add(new JLabel("Address"));
        infoPanel.add(new JLabel(artiste.getAddress()));
        infoPanel.add(new JLabel("Phone"));
        infoPanel.add(new JLabel(artiste.getTelNumber()));

        Component[] labels = infoPanel.getComponents();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("Avenir", Font.BOLD, 18));
        }

        add(infoPanel, BorderLayout.NORTH);

        setTitle("Profile");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}