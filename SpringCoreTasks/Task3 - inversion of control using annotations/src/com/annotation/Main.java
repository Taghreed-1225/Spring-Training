package com.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

           System.out.println("hoooo ");
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circle1 = container.getBean("circle", Shape.class);
        System.out.println( circle1.getArea(3));
        Shape square1 = container.getBean("square", Square.class);
        System.out.println(  square1.getArea(3));
    }}
