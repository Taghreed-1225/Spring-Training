package base;

import base.model.Question;
import base.model.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

            //define question object
            Question question=new Question("fffirstQuestion");

            //define list of answers
            List<Answer> answers=new ArrayList<>();

            //add answers to the list
            Collections.addAll(answers , new Answer("Q1 first answer"),
                    new Answer("Q1 second answer"));

            //put answer in object of question
             question.setAnswers(answers);


                  session.save(question);
            //commit the changes
            session.getTransaction().commit();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
