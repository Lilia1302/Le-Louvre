package com.example.Interface;

import java.util.List;

import com.example.Model.Oeuvre;

public interface IGalleryController {
    public boolean create(Oeuvre oeuvre);
    public Oeuvre read(String title);
    public boolean update(Oeuvre oeuvre);
    public boolean delete(String title);
    public List<Oeuvre> getAllOeuvres();
    public Oeuvre getOeuvreByTitle(String title);
}
