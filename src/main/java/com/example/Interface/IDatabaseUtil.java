package com.example.Interface;

import com.example.Model.Artiste;
import com.example.Model.Oeuvre;

public interface IDatabaseUtil {
    // artistes
    boolean addUser(String firstName, String lastName, String username, String password, String email, String address, String telNumber);
    boolean userExists(String email,String password);
    boolean emailExists(String email);
    Artiste getCurrentUser();
    // oeuvres
    boolean create(Oeuvre oeuvre);
    Oeuvre read(String title);
    boolean update(Oeuvre oeuvre);
    boolean delete(String title);
}
