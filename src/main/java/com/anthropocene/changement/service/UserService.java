package com.anthropocene.changement.service;

import com.anthropocene.changement.model.User;

public interface UserService {
    User getUtilisateur(String user, String mdp);
}
