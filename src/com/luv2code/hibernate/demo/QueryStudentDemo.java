package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List theStudents = session.createQuery("from Student").getResultList();
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where  s.lastName = 'Dawg'").getResultList();
            System.out.println("Student with last name Dawg: ");
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("done");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

}
