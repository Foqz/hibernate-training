package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            int studentId = 3;
            session.beginTransaction();
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Delete student with id: " + studentId);
            session.delete(myStudent);

            //delete Student with query
            System.out.println("Delete student with id: " + 2);
            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
