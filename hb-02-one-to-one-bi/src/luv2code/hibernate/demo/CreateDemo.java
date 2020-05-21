package luv2code.hibernate.demo;

import luv2code.entity.Instructor;
import luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Instructor tempInstructor = new Instructor("Kamil", "Fiks", "test@test.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.google.com", "coding");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor: " + tempInstructor);
            //this will also save details because of CascadeType.ALL
            session.save(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
