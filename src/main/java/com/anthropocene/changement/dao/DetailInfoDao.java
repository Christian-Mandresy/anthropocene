package com.anthropocene.changement.dao;

import com.anthropocene.changement.model.DetailInfo;

import java.util.List;

public interface DetailInfoDao {
    List findall();

    void save(DetailInfo detailInfo);

    void update(DetailInfo information);

    List rechercher(int id, String description);
}
