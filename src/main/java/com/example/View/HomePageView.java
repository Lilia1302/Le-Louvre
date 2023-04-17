package com.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import com.example.Interface.IHomePageView;

public class HomePageView extends JFrame implements IHomePageView{

    private JFrame frame;
    private JButton loginButton;
    private JButton signupButton;

    public HomePageView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Home Page");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenue au Louvre");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(6, 27, 438, 45);
        frame.getContentPane().add(lblNewLabel);

        loginButton = new JButton("Se connecter");
        loginButton.setBounds(95, 141, 117, 29);
        frame.getContentPane().add(loginButton);

        signupButton = new JButton("S'inscrire");
        signupButton.setBounds(244, 141, 117, 29);
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

