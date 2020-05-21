package luv2code.hibernate.demo;

import luv2code.entity.Instructor;
import luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            int theId = 1;
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, theId);
            if(instructor!=null) {
                System.out.println("deleting instructor with id " + theId);
                // will also delete detail because cascade ALL
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
