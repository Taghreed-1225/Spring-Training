package base;

import base.model.Answer;
import base.model.Course;
import base.model.Instructor;
import base.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();
        try {
            //open the transaction
            session.beginTransaction();

            //define list of courses
            List<Course> courses=new ArrayList<>();

            //define question object
            Instructor instructor=new Instructor("Ali");



            //add answers to the list
            courses.add(new Course("Math1",instructor));
             courses.add( new Course("Logic design",instructor));

            //put answer in object of question
            instructor.setCourses(courses);


            session.persist(instructor);
            //commit the changes
            session.getTransaction().commit();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }








    }
}
