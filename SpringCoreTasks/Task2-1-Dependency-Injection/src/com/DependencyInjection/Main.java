package com.DependencyInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape circle1 = container.getBean("circle", Shape.class);
        circle1.drawshape();
        Shape square1 = container.getBean("square", Shape.class);
        square1.drawshape();
    }
}
