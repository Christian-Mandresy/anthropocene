package com.anthropocene.changement.service.impl;

import com.anthropocene.changement.dao.DetailInfoDao;
import com.anthropocene.changement.model.DetailInfo;
import com.anthropocene.changement.service.DetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetailInfoServiceImpl implements DetailInfoService {

    private DetailInfoDao detailInfoDao;

    @Autowired
    public void setDetailInfoDao(DetailInfoDao detailInfoDao) {
        this.detailInfoDao = detailInfoDao;
    }

    @Override
    public List findall()
    {
        return detailInfoDao.findall();
    }

    @Override
    public void save(DetailInfo detailInfo)
    {
        detailInfoDao.save(detailInfo);
    }

    @Override
    public void update(DetailInfo detailInfo)
    {
        detailInfoDao.update(detailInfo);
    }

    @Override
    public List rechercher(int id, String description)
    {
        return detailInfoDao.rechercher(id,description);
    }
}
