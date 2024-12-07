package main.com.myApp;

import main.com.myApp.model.Product;
import main.com.myApp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {
          //  Product product=new Product("pro31","des for oro31",31,31,"manf","2024-11-22");

            //open the transaction
           session.beginTransaction();

           //How to store date/time in Hibernate

            // save the object
            //session.save(product);



              //HQL to get all the records
//            Query query=session.createQuery("from Product");
//            List<Product> productList=query.getResultList();
//            System.out.println(productList);



//            HQL to get records with pagination
          //  Query query=session.createQuery("from Product");
            // set start row
//                  query.setFirstResult(5);
//                  //set total rows to fetch
//                  query.setMaxResults(10);
//                  List list=query.getResultList();
//                  System.out.println(list);




         //   HQL to get total prices of all the products
            Query query=session.createQuery("select sum (price) from Product");
            List<Integer> list=query.getResultList();
            System.out.println("the sum of price is = " +list.get(0));


            //commit the changes
            session.getTransaction().commit();
        } catch (Exception e) {

           e.printStackTrace();
        }
    }
}
