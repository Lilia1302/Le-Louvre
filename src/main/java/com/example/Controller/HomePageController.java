package com.example.Controller;


import com.example.Form.LoginForm;
import com.example.Interface.IHomePageController;
import com.example.Model.Artiste;
import com.example.Model.DatabaseUtil;
import com.example.View.HomePageView;
import com.example.View.LoginView;
import com.example.View.ProfilView;
import com.example.View.SignupView;


public class HomePageController implements IHomePageController {
    private HomePageView view;

    public HomePageController(HomePageView view) {
        this.view = view;
        this.view.addLoginButtonListener(e -> {
            LoginView loginView = new LoginView();
            DatabaseUtil databaseUtil = new DatabaseUtil();
            LoginController loginController = new LoginController(loginView, databaseUtil);
            loginView.setController(loginController);
            this.view.hide();
            loginView.display();
            
        });

        this.view.addSignupButtonListener(e -> {
            SignupView signupView = new SignupView();
            DatabaseUtil databaseUtil = new DatabaseUtil();
            SignupController signupController = new SignupController(signupView, databaseUtil);
            signupView.setController(signupController);
            this.view.hide();
            signupView.display();
        });
        
    }

    @Override
    public void display() {
        view.show();
    }
}
