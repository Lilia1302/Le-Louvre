package com.example.Model;

public class Artiste {
   
    private String lastName;
    private String firstName;
    private String username;
    private String image;
    private String telNumber;
    private String address;
    private String email;
    private String password;

    public Artiste (String lastName, String firstName, String username, String image, String email, String telNumber, String address, String password){
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.image = image;
        this.email = email;
        this.telNumber = telNumber;
        this.address = address;
        this.password = password;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getImage() {
        return this.image;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPassword() {
        return this.password;
    }
}
