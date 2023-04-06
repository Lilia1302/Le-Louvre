package com.example.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.ActionListeners.SignupButtonListener;
import com.example.Form.LoginForm;
import com.example.Interface.ILoginController;
import com.example.Interface.ILoginView;
import com.example.Model.Artiste;
import com.example.Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ILoginView {

    private final Font mainFont = new Font("Avenir", Font.BOLD, 18);
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private LoginController controller;

    public LoginView() {
        this.tfEmail = new JTextField();
        this.pfPassword = new JPasswordField();
        initialize();
    }

    public void initialize() {
        /*Create the form */
        JLabel lbLoginForm = new JLabel("Login", SwingConstants.CENTER);
        lbLoginForm.setBorder(new EmptyBorder(10, 0, 10, 0));
        lbLoginForm.setFont(mainFont);

        JLabel lbLoginEmail = new JLabel("Email", SwingConstants.CENTER);
        lbLoginEmail.setFont(mainFont);

      
        this.tfEmail.setFont(mainFont);

        JLabel lbLoginPassword = new JLabel("Password", SwingConstants.CENTER);
        lbLoginPassword.setFont(mainFont);

        
        this.pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        lbLoginForm.setFont(new Font("Trebuchet MS", Font.BOLD, 40));

        formPanel.setLayout(new GridLayout(0,1,0,0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbLoginEmail);
        formPanel.add(this.tfEmail);
        formPanel.add(lbLoginPassword);
        formPanel.add(this.pfPassword);

        /*Create the button */
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.setBackground(Color.orange);
        btnLogin.setOpaque(true);
        btnLogin.setBorderPainted(false);
        btnLogin.setPreferredSize(new Dimension(400,80));

        btnLogin.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                controller.loginButtonClicked(email, password);
            }
        });

        JLabel lbRedirectionSignup = new JLabel("You don't have an account ?");
        JButton btnRedirectionSignup = new JButton("Sign up");
        btnRedirectionSignup.setPreferredSize(new Dimension(100,50));

        /*btnRedirectionSignup.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.redirectToSignup();
            }
        });*/

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
        buttonsPanel.add(lbRedirectionSignup, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(30, 0, 50, 50);
        buttonsPanel.add(btnRedirectionSignup, gbc);

        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login");
        setSize(480, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setController(LoginController controller) {
        this.controller = controller;
    }

    @Override
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void clearFields() {
        tfEmail.setText("");
        pfPassword.setText("");
    }


@Override
    public void display() {
        // Afficher la vue
        setVisible(true);
    }
}
    


