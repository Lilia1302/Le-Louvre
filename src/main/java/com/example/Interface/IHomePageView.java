package com.example.Interface;
import java.awt.event.ActionListener;
public interface IHomePageView {

    void show();
    void addLoginButtonListener(ActionListener listener);
    void addSignupButtonListener(ActionListener listener);
    void hide();
}



