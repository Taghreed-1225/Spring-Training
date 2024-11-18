package com.annotation;
import org.springframework.stereotype.Component;
@Component("square")
public class Square implements Shape {
    @Override
    public double getArea(int l) {
        return l*l;
    }
}
