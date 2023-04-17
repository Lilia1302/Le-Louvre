package com.example.Controller;

import com.example.Interface.ILoginController;
import com.example.Model.Artiste;
import com.example.Model.DatabaseUtil;
import com.example.View.LoginView;
import com.example.View.ProfilView;
import com.example.View.SignupView;

public class LoginController implements ILoginController {

        private LoginView loginView;
        private final DatabaseUtil databaseUtil;

    public LoginController(LoginView loginView, DatabaseUtil databaseUtil) {
        this.loginView = loginView;
        this.databaseUtil = databaseUtil;
        this.loginView.setController(this);
    }

    @Override
    public void loginButtonClicked(String email,String password) {
        if (email.isEmpty() || password.isEmpty()) {
            loginView.showError("Please enter both username and password.");
        } else {
            boolean success = databaseUtil.userExists(email,password);
            if (success) {
                // Redirection vers la page de profil de l'utilisateur
            Artiste currentUser = databaseUtil.getCurrentUser();
            databaseUtil.setCurrentUser(currentUser);
            ProfilView profilView = new ProfilView();
            ProfilController profilController = new ProfilController(profilView, databaseUtil);
            profilView.setController(profilController);
            profilView.displayProfilData(currentUser);
            
            // Fermeture de la vue de connexion
            loginView.dispose();
            } else {
                loginView.showError("Failed to connect user.");
            }
        }
    }

    @Override
    public void login() {
        String password = loginView.getPassword();
       
        String email = loginView.getEmail();
       
        loginButtonClicked(email, password);
    }

    @Override
    public void setView(LoginView loginView) {
        this.loginView = loginView;
        this.loginView.setController(this);
    }

    public void redirectToSignup() {
        SignupView signupView = new SignupView();
        signupView.display();
        this.loginView.setVisible(false);
    }
}
    

