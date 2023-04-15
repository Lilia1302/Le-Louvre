package com.example.Interface;

import com.example.Model.Artiste;

public interface IDatabaseUtil {
    boolean addUser(String firstName, String lastName, String username, String password, String email, String address, String telNumber);
    boolean userExists(String email,String password);
    boolean emailExists(String email);
    Artiste getCurrentUser();
}
