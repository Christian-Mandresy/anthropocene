package com.anthropocene.changement.service;

import com.anthropocene.changement.model.DetailInfo;

import java.util.List;

public interface DetailInfoService {
    List findall();

    void save(DetailInfo detailInfo);

    void update(DetailInfo detailInfo);

    List rechercher(int id, String description);
}
