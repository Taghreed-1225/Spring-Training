package com.depenancyInhection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Vehicle plan1 = container.getBean("plan", Vehicle.class);
        plan1.savaData(plan1);
    }
}