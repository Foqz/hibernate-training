package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            System.out.println("creating object for studdent");
            Student tempStudent = new Student("Kamil", "Fiks", "testEmail@test.com");
            session.beginTransaction();
            System.out.println("saving student");
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("done");
        } finally {
            factory.close();
        }
    }
}
