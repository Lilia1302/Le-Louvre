package com.example;

public class Salle {
    private String number;
    private double surface;

    public Salle (String number, double surface) {
        this.number = number;
        this.surface = surface;
    }

    public String getNumber() {
        return this.number;
    }

    public double getSurface() {
        return this.surface;
    }
}
