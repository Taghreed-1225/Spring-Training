package com.inversionOfControl;

public class Circle implements Shape{

    private int radius;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(int radius) {
       // double r = radius / 2.0;
        return Math.PI*radius*radius;
    }
}
