package com.example.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;

public class SideBar extends JFrame{
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JSplitPane splitPane;
    private JToggleButton menuButton;
    ImageIcon menuIcon;
    private final int NOMBRE_BOUTONS_MENU;
    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);

    public SideBar() {

        // création du menu
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.ORANGE);
        menuPanel.setBorder(null);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, getHeight()));
        
        String[] buttons = new String[] {"Accueil", "Galerie", "Exposition", "", "", "Connexion", "Inscription", "Quitter"};
        NOMBRE_BOUTONS_MENU = buttons.length;

        for (int i = 0; i < NOMBRE_BOUTONS_MENU; i++) {
            JButton optionButton = new JButton();
            optionButton.setName("option" + (i+1) + "Button"); // donner un nom dynamique au bouton
            optionButton.setText(buttons[i]);
            optionButton.setPreferredSize(new Dimension(menuPanel.getPreferredSize().width, 100));
            optionButton.setAlignmentX(Component.CENTER_ALIGNMENT); //ajout de cette ligne pour centrer les boutons
            optionButton.setBackground(Color.YELLOW); // couleur de fond jaune
            optionButton.setBorder(null); // supprimer le bord du bouton
            optionButton.setFont(mainFont);
            menuPanel.add(optionButton);

            // Ajouter un écouteur d'événements au bouton en utilisant une expression lambda
            optionButton.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                String buttonName = clickedButton.getName();
                if ("option1Button".equals(buttonName)) {
                    HomePageView homePageView = new HomePageView();
                    homePageView.setVisible(true);
                    this.setVisible(false);
                } else if ("option2Button".equals(buttonName)) {
                    /*GalerieView galerieView = new GalerieView();
                    //galerieView.setVisible(true);
                    this.setVisible(false);*/
                } else if ("option3Button".equals(buttonName)) {
                    /*ExpositionView expositionView = new ExpositionView();
                    expositionView.setVisible(true);
                    this.setVisible(false);*/
                } else if ("option6Button".equals(buttonName)) {
                    LoginView loginView = new LoginView();
                    loginView.setVisible(true);
                    this.setVisible(false);
                } else if ("option7Button".equals(buttonName)) {
                    SignupView signupView = new SignupView();
                    signupView.setVisible(true);
                    this.setVisible(false);
                } else if ("option8Button".equals(buttonName)) {
                    System.exit(0);
                }
            });
        }

        // création du contenu de la galerie
        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setBorder(null);

        // création du split pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, contentPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);
        splitPane.setDividerSize(0);
        splitPane.setBorder(null);

        // création du bouton de menu
        ImageIcon icon = new ImageIcon("/Applications/MAMP/htdocs/Le-Louvre/src/main/java/com/example/View/Images/menuIcon.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        menuButton = new JToggleButton(newIcon);
        menuButton.setPreferredSize(new Dimension(50, 50));
        menuButton.setBorder(null);

        menuButton.addActionListener(e -> {
            if (menuButton.isSelected()) {
                splitPane.setDividerLocation(0);
            } else {
                splitPane.setDividerLocation(200);
            }
        });

        // création du panneau de bouton de menu
        JPanel menuButtonPanel = new JPanel(new BorderLayout());
        menuButtonPanel.setPreferredSize(new Dimension(getWidth(), 70));
        menuButtonPanel.add(menuButton, BorderLayout.WEST);
        menuButtonPanel.setBackground(Color.ORANGE);

        // Création du JLabel contenant le titre
        JLabel titleLabel = new JLabel("Le Louvre");
        titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(titleLabel);
        titleBox.add(Box.createHorizontalGlue());
        menuButtonPanel.add(titleBox, BorderLayout.CENTER);

        // création du panneau principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(menuButtonPanel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        contentPanel.setOpaque(false);
        contentPanel.setBorder(null);

        // ajout du panneau principal à la fenêtre
        this.add(mainPanel);

        // configuration de la fenêtre
        this.setTitle("Ma Galerie");
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(600, 500));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SideBar();
    }
}