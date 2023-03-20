package com.example.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.Model.Artiste;
import com.example.Model.LoginForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView extends JFrame {
    protected static final Component LoginForm = null;
    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;


    public void initialize() {
        /*Create the form */
        JLabel lbLoginForm = new JLabel("Login", SwingConstants.CENTER);
        lbLoginForm.setBorder(new EmptyBorder(10, 0, 10, 0));
        lbLoginForm.setFont(mainFont);

        JLabel lbLoginEmail = new JLabel("Email", SwingConstants.CENTER);
        lbLoginEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbLoginPassword = new JLabel("Password", SwingConstants.CENTER);
        lbLoginPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        lbLoginForm.setFont(new Font("Trebuchet MS", Font.BOLD, 40));

        formPanel.setLayout(new GridLayout(0,1,0,0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbLoginEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbLoginPassword);
        formPanel.add(pfPassword);

        /*Create the button */
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.setPreferredSize(new Dimension(400,80));

        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                LoginForm loginForm = new LoginForm();
                Artiste artiste = loginForm.getAuthentificatedUser(email, password);

                if (artiste != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.init(artiste);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm,
                    "Invalid email or password",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel lbRedirectionSignIn = new JLabel("You don't have an account ?");
        JButton btnRedirectionSignIn = new JButton("Sign up");
        btnRedirectionSignIn.setPreferredSize(new Dimension(100,50));

        btnRedirectionSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // rediriger vers la page d'inscription
                // ici, on utilise JOptionPane.showInputDialog() comme exemple
                String newEmail = JOptionPane.showInputDialog("Enter your username:");
                String newPassword = JOptionPane.showInputDialog("Enter your password:");
                System.out.println("New user registered: " + newEmail + ", " + newPassword);
            }
        });

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonsPanel.add(btnLogin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(30, 50, 50, 0);
        buttonsPanel.add(lbRedirectionSignIn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(30, 0, 50, 50);
        buttonsPanel.add(btnRedirectionSignIn, gbc);

        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login");
        setSize(480, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}

