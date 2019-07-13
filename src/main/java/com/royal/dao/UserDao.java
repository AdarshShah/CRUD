package com.royal.dao;

import com.royal.bean.UserBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class UserDao {
    private static SessionFactory sessionFactory;
    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void insert(UserBean user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }

    public List getAll() {
        Session session = sessionFactory.openSession();
        Criteria cs = session.createCriteria(UserBean.class);
        List list = new List(cs.list();
        session.close();
        return list;
    }

    public void remove(UserBean user){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(user);
            tx.commit();      
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }
}