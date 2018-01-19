package Dao.impl;

import Dao.Hibernateutil;
import Dao.UserDao;
import DoMain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.management.Query;

public class UserDaoHibernateImpl implements UserDao{
    //moban
    @Override
    public void saveUser(User user) {
        Session s=null;
        Transaction  tx=null;
        try {
            s= Hibernateutil.getSession();
            tx=s.beginTransaction();
            s.save(user);
            tx.commit();
        }catch (Exception e) {
            if (tx!=null)tx.rollback();throw  e;
        }finally{
            if (s!=null){
                s.close();
            }
        }
    }

    @Override
    public User findUserById(int id) {
        Session s=null;
        try {
            s= Hibernateutil.getSession();
            User user=(User) s.get(User.class,id);
            return user;
        }finally {
            if (s!=null){
                s.close();
            }
        }

    }

    @Override
    public User findUserByName(String name) {
        Session s=null;
        try {
            s= Hibernateutil.getSession();
            Criteria c=s.createCriteria(User.class);
            c.add(Restrictions.eq("name",name));
            User user=(User) c.uniqueResult();
            return user;
        }finally {
            if (s!=null){
                s.close();
            }
        }
    }


    public User findUserByName1(String name) {
        Session s=null;
        try {
            s= Hibernateutil.getSession();
            String hql="from User as user where user.name=:n";
            org.hibernate.Query q=s.createQuery(hql);
            q.setString("n",name);
            User user=(User) q.uniqueResult();
            return user;
        }finally {
            if (s!=null){
                s.close();
            }
        }
    }

    @Override
    public void updateuser(User user) {
        Session s=null;
        Transaction  tx=null;
        try {
            s= Hibernateutil.getSession();
            tx=s.beginTransaction();
            s.update(user);
            tx.commit();
        }finally {
            if (s!=null){
                s.close();
            }
        }
    }

    @Override
    public void remove(User user) {
        Session s=null;
        Transaction  tx=null;
        try {
            s= Hibernateutil.getSession();
            tx=s.beginTransaction();
            s.delete(user);
            tx.commit();
        }finally {
            if (s!=null){
                s.close();
            }
        }
    }
}
