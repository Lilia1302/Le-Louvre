package com.example.Model;

public class Oeuvre {
    private String title;
    private String artist;
    private double estimatedPrice;
    private String type;
    private String dimension;

    public Oeuvre (String title, String artist, double estimatedPrice, String type, String dimension) {
        this.title = title;
        this.artist = artist;
        this.estimatedPrice = estimatedPrice;
        this.type = type;
        this.dimension = dimension;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getEstimatedPrice() {
        return this.estimatedPrice;
    }

    public void setEstimatedPrice(double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }
    
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return this.dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
