package Dao;

import DoMain.Many2one.Department;
import DoMain.Many2one.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManytooOnetest {
    public static void main(String[] args) {
//        add();
//        select(2);
        selectde(8);
    }

    static void add() {
        Session session = null;
        Transaction transaction = null;
        try {
            Department department = new Department();
            department.setName("depart name");

            Employee employee = new Employee();
            employee.setDepart(department);
            employee.setName("employee name");

            Employee employee1 = new Employee();
            employee1.setDepart(department);
            employee1.setName("employee name22");

            session = Hibernateutil.getSession();
            transaction = session.beginTransaction();

            session.save(department);
            session.save(employee);
            session.save(employee1);
            transaction.commit();
        } finally {
            if (session != null) session.close();
        }
    }

    static void select(int emp_id) {
        Session s = null;
        Transaction tx = null;
        try {
            s = Hibernateutil.getSession();
            tx = s.beginTransaction();

            Employee employee = s.get(Employee.class, emp_id);
            System.out.println(employee.getName() + "," + employee.getDepart().getName());
            tx.commit();
        } finally {
            if (s != null) s.close();
        }
    }

    static Department selectde(int deId) {
        Session s = null;
        Transaction tx = null;
        try {
            s = Hibernateutil.getSession();
            tx = s.beginTransaction();

            Department department = s.get(Department.class, deId);
            Hibernate.isInitialized(department.getEmployees());
            System.out.println(department.getName() + "," + department.getEmployees().size());
            tx.commit();
            return department;
        } finally {
            if (s != null) s.close();
        }
    }
}
