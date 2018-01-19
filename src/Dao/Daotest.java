package Dao;

import Dao.impl.UserDaoHibernateImpl;
import DoMain.User;

import java.util.Date;

public class Daotest {

    public static void main(String[] args) {
        UserDao dao = new UserDaoHibernateImpl();
        User user = new User();
        user.setName("test");
        user.setBirthday(new Date());
        System.out.println("111");

        dao.saveUser(user);


        user.setName("newTest");
        System.out.println("222");

        dao.updateuser(user);

        User user1 = dao.findUserByName(user.getName());
        System.out.println("333");
//        dao.remove(user1);
    }
}
