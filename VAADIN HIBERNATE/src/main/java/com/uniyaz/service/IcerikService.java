package com.uniyaz.service;

import com.uniyaz.domain.Icerik;
import com.uniyaz.domain.Kullanicilar;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class IcerikService {


    public void save(Icerik icerik) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();){
            Transaction transaction = session.beginTransaction();
            session.merge(icerik);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public void sil(Icerik listele) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();){
            Transaction transaction = session.beginTransaction();
            session.delete(listele);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
