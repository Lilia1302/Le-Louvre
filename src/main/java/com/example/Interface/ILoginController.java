package com.example.Interface;

import com.example.Form.LoginForm;
import com.example.View.LoginView;

public interface ILoginController {
    void login(LoginForm loginForm);
    void loginButtonClicked(String username, String password);
    void setView(LoginView view);    
}
