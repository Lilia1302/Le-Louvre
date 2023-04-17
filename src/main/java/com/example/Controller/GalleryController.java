package com.example.Controller;

import com.example.Interface.IGalleryController;
import com.example.Interface.IGalleryView;
import com.example.Model.DatabaseUtil;
import com.example.Model.Oeuvre;

import java.util.List;

public class GalleryController implements IGalleryController {
    IGalleryView view;
    private DatabaseUtil dbUtil;

    public GalleryController(IGalleryView view, DatabaseUtil dbUtil) {
        this.view = view;
        this.dbUtil = dbUtil;
        view.setController(this);
    }

    @Override
    public boolean create(Oeuvre oeuvre) {
        return dbUtil.create(oeuvre);
    }

    @Override
    public Oeuvre read(String title) {
        return dbUtil.read(title);
    }

    @Override
    public boolean update(Oeuvre oeuvre) {
        return dbUtil.update(oeuvre);
    }

    @Override
    public boolean delete(String title) {
        return dbUtil.delete(title);
    }

    // Méthode pour récupérer toutes les œuvres de la base de données
    public List<Oeuvre> getAllOeuvres() {
        return dbUtil.getAllOeuvres();
    }

    // Méthode pour récupérer une œuvre par son titre depuis la base de données
    public Oeuvre getOeuvreByTitle(String title) {
        return dbUtil.getOeuvreByTitle(title);
    }
}