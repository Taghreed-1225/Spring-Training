package com.DependencyInjection;

public class Circle implements Shape{
    public Draw2d D2d;
// constructor injection
    public Circle(Draw2d d2d) {
        D2d = d2d;
    }

    @Override
    public void drawshape() {
        D2d.draw("Circle");
    }
}
