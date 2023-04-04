package com.example.Interface;
import com.example.Controller.SignupController;
import com.example.Form.SignupForm;

public interface ISignupView {
    void showError(String message);
    void showSuccess(String message);
    SignupForm getSignupForm();
    void clearFields();
    void setController(SignupController controller);
    void display();
    void close();
    }
    
