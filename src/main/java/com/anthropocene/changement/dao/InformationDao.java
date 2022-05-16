package com.anthropocene.changement.dao;

import com.anthropocene.changement.model.Information;

import java.util.Date;
import java.util.List;

public interface InformationDao {
    List findall();

    void save(Information information);

    void update(Information information);

    List rechercher(String titre, String auteur, Date date1, Date date2);
}
