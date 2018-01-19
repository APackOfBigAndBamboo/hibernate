package Dao;

import DoMain.Many2Many.Student;
import DoMain.Many2Many.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class ManyTooMan {
    public static void main(String[] args) {
        new ManyTooMan().add();
    }

    void add() {
        Session s = null;
        Transaction tx = null;
        try {
            s = Hibernateutil.getSession();
            tx = s.beginTransaction();
            Set<Teacher> tt = new HashSet<Teacher>();
            Teacher teacher1 = new Teacher();
            teacher1.setName("t1");
            tt.add(teacher1);

            Teacher teacher12 = new Teacher();
            teacher12.setName("t2");
            tt.add(teacher12);

            Set<Student> ss = new HashSet<Student>();
            Student student1 = new Student();
            student1.setName("s1");
            ss.add(student1);

            Student student2 = new Student();
            student2.setName("s2");
            ss.add(student2);
//
//            teacher1.setStudents(ss);
//            teacher12.setStudents(ss);
            student1.setTeacher(tt);
            student2.setTeacher(tt);

            s.save(teacher1);
            s.save(teacher12);
            s.save(student1);
            s.save(student2);
            tx.commit();
        } finally {
            if (s != null) s.close();
        }
    }
}
