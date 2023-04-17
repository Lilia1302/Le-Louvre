package com.example.Controller;

import com.example.Interface.IDatabaseUtil;
import com.example.Interface.IProfilController;

import com.example.Model.Artiste;
import com.example.Model.DatabaseUtil;
import com.example.View.ProfilView;

public class ProfilController implements IProfilController {
    private IDatabaseUtil databaseUtil;

    public ProfilController(ProfilView view, DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
        view.setController(this);
    }

    @Override
    public Artiste getCurrentUser() {
        return databaseUtil.getCurrentUser();
    }
}
