package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernateutil {
    public static SessionFactory sessionFactory;
    private Hibernateutil(){}
    static {
        Configuration cfg=new Configuration();
        cfg.configure();
        sessionFactory=cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session  getSession(){
        return sessionFactory.openSession();
    }
}
