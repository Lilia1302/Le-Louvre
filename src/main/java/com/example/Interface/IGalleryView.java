package com.example.Interface;

import java.util.List;

import com.example.Controller.GalleryController;
import com.example.Model.Oeuvre;

public interface IGalleryView {
    void setController(GalleryController controller);
    public void display();
    public void close();
    public  List<Oeuvre> afficherOeuvres(List<Oeuvre> allOeuvres);
}