package Dao;

import DoMain.One2One.IdCard;
import DoMain.One2One.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class One2One {
    public static void main(String[] args) {
      Person person=  add();
        System.out.println(select(person.getId()).getIdCard().getUsefullife());
    }

    static Person add() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Hibernateutil.getSession();
            transaction = session.beginTransaction();
            IdCard idCard = new IdCard();
            idCard.setUsefullife(new Date());

            Person person = new Person();
            person.setName("person");
//            person.setIdCard(idCard);
            idCard.setPerson(person);
            session.save(person);
            session.save(idCard);
            transaction.commit();
            return person;
        } finally {
            if (session != null) session.close();
        }
    }
    static Person select(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Hibernateutil.getSession();
            transaction = session.beginTransaction();
           Person person=session.get(Person.class,id);
            transaction.commit();
            return person;
        } finally {
            if (session != null) session.close();
        }
    }

}
