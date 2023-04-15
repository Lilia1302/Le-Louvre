package com.example.Controller;

import com.example.Interface.IDatabaseUtil;
import com.example.Interface.IProfilController;
import com.example.Interface.IProfilView;
import com.example.Model.Artiste;

public class ProfilController implements IProfilController {
    private IDatabaseUtil databaseUtil;

    public ProfilController(IProfilView view, IDatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
        view.setController(this);
    }

    @Override
    public Artiste getCurrentUser() {
        return databaseUtil.getCurrentUser();
    }
}
