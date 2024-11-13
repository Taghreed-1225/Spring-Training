package com.BeanScope;

//import org.springframework.stereotype.Component;

//@Component("")

public class Square implements Shape
{
    draw2d d2d;

    public void setD2d(draw2d d2d) {
        this.d2d = d2d;
    }

    @Override
    public void draw() {
        d2d.Draw2d("square");

    }

}
