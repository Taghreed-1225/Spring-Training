package main.com.myApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.com.myApp.model.UserModel;



public class Main {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(UserModel.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
            // define object to be inserted
            UserModel userModel=new UserModel(1, "Taghreed", "Taghredd1225@gmail.com","password");

            //open the transaction
            session.beginTransaction();

            // save the object
            //session.save(userModel);

            // define id
            int id =1;

            //retrieve object from database
            UserModel userModel1 = session.get(UserModel.class , 1);
            System.out.println(userModel1);

            //update
            //userModel1.setPassword("123456");

            //delete
            session.delete(userModel1);


            //commit the changes
            session.getTransaction().commit();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }





    }
}
