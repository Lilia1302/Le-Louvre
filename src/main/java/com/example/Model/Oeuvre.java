package com.example.Model;

public class Oeuvre {
    private String name;
    private double estimatedPrice;
    private String type;
    private String dimension;

    public Oeuvre (String name, double estimatedPrice, String type, String dimension) {
        this.name = name;
        this.estimatedPrice = estimatedPrice;
        this.type = type;
        this.dimension = dimension;
    }

    public String getName() {
        return this.name;
    }

    public double getEstimatedPrice() {
        return this.estimatedPrice;
    }
    
    public String getType() {
        return this.type;
    }

    public String getDimension() {
        return this.dimension;
    }
    





}
