package base;

import base.model.Question;
import base.model.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {


    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Answer.class).addAnnotatedClass(Question.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();
        try {
            //open the transaction
            session.beginTransaction();




            //commit the changes
            session.getTransaction().commit();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
