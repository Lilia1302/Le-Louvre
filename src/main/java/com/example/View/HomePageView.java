package com.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import com.example.Interface.IHomePageView;

public class HomePageView extends JFrame implements IHomePageView{

    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);
    private JFrame frame;
    private JButton loginButton;
    private JButton signupButton;

    public HomePageView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Home Page");
        frame.setLocationRelativeTo(null);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenue au Louvre");
        lblNewLabel.setFont(mainFont);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(10, 27, 438, 45);
        frame.getContentPane().add(lblNewLabel);

        loginButton = new JButton("Se connecter");
        loginButton.setFont(mainFont);
        loginButton.setBounds(50, 141, 150, 50);
        loginButton.setBackground(Color.orange);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        frame.getContentPane().add(loginButton);

        signupButton = new JButton("S'inscrire");
        signupButton.setFont(mainFont);
        signupButton.setBounds(244, 141, 150, 50);
        signupButton.setBackground(Color.orange);
        signupButton.setOpaque(true);
        signupButton.setBorderPainted(false);
        frame.getContentPane().add(signupButton);
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    @Override
    public void addSignupButtonListener(ActionListener listener) {
        signupButton.addActionListener(listener);
    }

    @Override
    public void hide() {
        this.frame.setVisible(false);
    }
}

