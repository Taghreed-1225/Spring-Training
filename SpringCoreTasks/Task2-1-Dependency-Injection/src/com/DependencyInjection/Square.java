package com.DependencyInjection;

public class Square implements Shape{
    public Draw2d D2d;


    // setter injection
    public void setD2d(Draw2d D2d) {
        this.D2d = new Draw2d();
    }
    @Override
    public void drawshape() {
        D2d.draw("Square");
    }
}
