package luv2code.hibernate.demo;

import luv2code.entity.Instructor;
import luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            int theId = 2;
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("Printing instructor detail: " + instructorDetail);
            System.out.println("Associated instructor: " + instructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
