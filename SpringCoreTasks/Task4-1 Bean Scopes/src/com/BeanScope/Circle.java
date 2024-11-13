package com.BeanScope;

public class Circle implements Shape {
    draw2d d2d;

    public Circle(draw2d d2d) {
        this.d2d = d2d;
    }

    @Override
    public void draw() {
        d2d.Draw2d("circle");

    }

}
