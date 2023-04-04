package com.example.Interface;

import com.example.Form.SignupForm;

public interface ISignupController {
    void createAccount(SignupForm signupForm);
    void signupButtonClicked(String firstName, String lastName, String username, String password, String email, String address, String telNumber);
    void setView(ISignupView view);
}

