package com.anthropocene.changement.dao.impl;

import com.anthropocene.changement.dao.InformationDao;
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

public class InformationDaoImpl implements InformationDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List findall()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(Information.class).list();
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
    public void save(Information information)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(information);
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
    public void update(Information information)
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
    public List rechercher(String titre, String auteur, Date date1, Date date2)
    {
        Session session = this.sessionFactory.openSession();
        try {

            // test si dans la clause where il faut mettre where ou and
            Boolean test=true;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            StringBuilder sql=new StringBuilder("select * ");
            if(titre.equals("") == false)
            {
                sql.append(test ? "where " : " and ");
                sql.append("titre = "+titre);
                test=false;
            }
            if(auteur.equals("") == false)
            {
                sql.append(test ? "where " : " and ");
                sql.append("auteur = "+auteur);
                test=false;
            }
            if (date1 != null) {
                sql.append(test ? "where " : " and ");
                sql.append("datepublication between "+"'"+dateFormat.format(date1)+"'"+" and "+"'"+dateFormat.format(date2)+"'");
                test=false;
            }
            String queryFinal=sql.toString();
            SQLQuery query= session.createSQLQuery(queryFinal)
                    .addEntity(Information.class);
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
