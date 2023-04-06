package com.example.Interface;

import com.example.Controller.LoginController;

public interface ILoginView {
   
    void display();
    String getPassword();
    void showError(String message);
    void showSuccessMessage(String message);
    void setController(LoginController controller);
    void clearFields();
    
}
