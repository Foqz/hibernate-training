package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            int studentId = 1;
            session.beginTransaction();
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Got student with id: " + studentId);
            System.out.println("Updating student...");
            myStudent.setFirstName("Bogdan");
            session.getTransaction().commit();
            System.out.println("Done");

            //Update all emails with query
            System.out.println("update all emails to foo@gmail.com");
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
