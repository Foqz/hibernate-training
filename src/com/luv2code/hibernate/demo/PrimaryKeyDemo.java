package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            System.out.println("creating 3 student objects");
            Student tempStudent1 = new Student("Robert", "Fiks", "test1Email@test.com");
            Student tempStudent2 = new Student("Paul", "Fiks", "test2Email@test.com");
            Student tempStudent3 = new Student("Marcin", "Fiks", "test3Email@test.com");

            session.beginTransaction();
            System.out.println("saving students");

            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("done");
        } finally {
            factory.close();
        }
    }
}
