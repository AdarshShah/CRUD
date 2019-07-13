package com.royal.dao;

import com.royal.bean.UserBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class UserDao {
    private Session session;

    public UserDao() {
        this.session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
    }

    public void insert(UserBean user) {
        Transaction tx = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public List getAll() {
        Criteria cs = session.createCriteria(UserBean.class);
        return cs.list();
    }

    public void remove(UserBean user){
        Transaction tx = session.beginTransaction();
        try {
            session.delete(user);
            tx.commit();      
        } catch (Exception e) {
            tx.rollback();
        }
    }
}