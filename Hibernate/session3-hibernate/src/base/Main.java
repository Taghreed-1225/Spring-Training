package base;

import base.model.Passport;
import base.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {


    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)  .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();
        try {
            //open the transaction
            session.beginTransaction();

            //create object
           // Passport passport=new Passport("tag1234","2030-5-5");

           // Person person=new Person("tag","ali","2001-1-1");
            //passport.setPersonId(person);
            // save the object
            //session.save(passport);


            // fetch passport by id and its person
            int id =3;
            Passport passport=session.get(Passport.class,3);
            System.out.println(passport.getPassportNo()+" "+passport.getExpiryDate());



            //commit the changes
            session.getTransaction().commit();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
