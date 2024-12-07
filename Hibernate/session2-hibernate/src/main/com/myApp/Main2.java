package main.com.myApp;

import main.com.myApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
            User user = new User("Taghreed", "root");
            //open the transaction
            session.beginTransaction();

            // save the object
            session.save(user);


            //commit the changes
            session.getTransaction().commit();
        } catch (Exception e) {

           e.printStackTrace();
        }
    }
}


