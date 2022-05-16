package com.anthropocene.changement.dao.impl;

import com.anthropocene.changement.dao.DetailInfoDao;
import com.anthropocene.changement.model.DetailInfo;
import com.anthropocene.changement.model.Information;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DetailInfoDaoImpl implements DetailInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List findall()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(DetailInfo.class).list();
            tx.commit();
            return type;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(DetailInfo detailInfo)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(detailInfo);
            tx.commit();
        }catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }finally{
            session.close();
        }
    }

    @Override
    public void update(DetailInfo information)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(information);
            tx.commit();
        }catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }finally{
            session.close();
        }
    }

    @Override
    public List rechercher(int id, String description)
    {
        Session session = this.sessionFactory.openSession();
        try {

            // test si dans la clause where il faut mettre where ou and
            Boolean test=true;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            StringBuilder sql=new StringBuilder("select * ");
            if(id != 0)
            {
                sql.append(test ? "where " : " and ");
                sql.append("idInfo = "+id);
                test=false;
            }
            if(description.equals("") == false)
            {
                sql.append(test ? "where " : " and ");
                sql.append("titre like '%"+description+"%' ");
                test=false;
            }

            String queryFinal=sql.toString();
            SQLQuery query= session.createSQLQuery(queryFinal)
                    .addEntity(DetailInfo.class);
            List resultat = query.list();
            return resultat;
        } catch (Exception e) {
            throw e;
        }
        finally {
            session.close();
        }
    }
}
