package aop;// Created by Neginskiy Gregoriy.

import org.springframework.stereotype.Component;

@Component
public class PointCutSample implements IPointCut {

    public void doSomething() {
        System.out.println("doing something great! "+this);
    }
}
