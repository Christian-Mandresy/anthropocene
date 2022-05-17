package com.anthropocene.changement.service.impl;

import com.anthropocene.changement.dao.UserDao;
import com.anthropocene.changement.model.User;
import com.anthropocene.changement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUtilisateur(String user, String mdp)
    {
        return userDao.getUtilisateur(user,mdp);
    }
}
