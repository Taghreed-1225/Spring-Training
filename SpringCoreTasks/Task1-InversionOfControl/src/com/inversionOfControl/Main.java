package com.inversionOfControl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){


        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circle1=container.getBean("circle" ,Shape.class);
        Shape square1=container.getBean("square" ,Shape.class);
        // use bean
        System.out.println("the area of the circle ="+circle1.getArea(3));
        System.out.println("the area of the Square ="+square1.getArea(3));


    }
}
