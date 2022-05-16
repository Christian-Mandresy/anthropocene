package com.anthropocene.changement.service.impl;

import com.anthropocene.changement.dao.InformationDao;
import com.anthropocene.changement.model.Information;
import com.anthropocene.changement.service.InformationService;

import java.util.Date;
import java.util.List;

public class InformationServiceImpl implements InformationService {

    private InformationDao informationDao;

    public List findall()
    {
        return informationDao.findall();
    }

    public void save(Information information)
    {
        informationDao.save(information);
    }

    public void update(Information information)
    {
        informationDao.update(information);
    }

    public List rechercher(String titre, String auteur, Date date1, Date date2)
    {
        return informationDao.rechercher(titre,auteur,date1,date2);
    }
}
