package com.uniyaz.service;

import com.uniyaz.domain.Icerik;
import com.uniyaz.domain.Kullanicilar;
import com.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class KullaniciService {


    public void save(Kullanicilar kullanicilar) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction();
            session.merge(kullanicilar);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Kullanicilar findKullanicilar(String kullaniciAdi,String sifre) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "Select kullanicilar FROM Kullanicilar kullanicilar WHERE kullaniciAdi='" + kullaniciAdi + "' and sifre ='" + sifre + "'";
        Query query = session.createQuery(hql);
        return (Kullanicilar) query.uniqueResult();


    }

}


