package com.annotation;
import org.springframework.stereotype.Component;
@Component("circle")
public class Circle implements Shape {

    @Override
    public double getArea(int radius) {
        return radius*radius*Math.PI;
    }
}
