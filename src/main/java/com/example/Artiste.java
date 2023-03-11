package com.example;


public class Artiste {
    private String lastName;
    private String firstName;
    private String username;
    private String image;
    private String telNumber;
    private String address;

    public Artiste (String lastName, String firstName, String username, String image, String telNumber, String address){
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.image = image;
        this.telNumber = telNumber;
        this.address = address;
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

    public String getTelNumber() {
        return this.telNumber;
    }

    public String getAddress() {
        return this.address;
    }
}
