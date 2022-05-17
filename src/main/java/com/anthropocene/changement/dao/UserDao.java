package com.anthropocene.changement.dao;

import com.anthropocene.changement.model.User;

public interface UserDao {
    User getUtilisateur(String util, String mdp);
}
