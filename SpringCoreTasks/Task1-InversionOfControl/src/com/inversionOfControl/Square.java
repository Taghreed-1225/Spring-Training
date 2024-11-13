package com.inversionOfControl;

public class Square implements Shape{

    private int l;



    @Override
    public double getArea(int l) {
        return l*l;
    }

}
