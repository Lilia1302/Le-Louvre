package com.example.Interface;

public interface IDatabaseUtil {
    boolean addUser(String firstName, String lastName, String username, String password, String email, String address, String telNumber);
    boolean userExists(String email,String password);
    boolean emailExists(String email);
}
