package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Course course = new Course("Pacman");
            course.addReview(new Review("Nice course"));
            course.addReview(new Review("This course sucks!"));
            course.addReview(new Review("Meh..."));

            System.out.println("Saving the course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }
}
