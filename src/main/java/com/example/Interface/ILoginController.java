package com.example.Interface;


import com.example.View.LoginView;

public interface ILoginController {
    void login();
    void loginButtonClicked(String username, String password);
    void setView(LoginView view);    
}
