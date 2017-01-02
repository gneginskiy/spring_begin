package spring.objects;// Created by Neginskiy Gregoriy.

import spring.interfaces.Leg;

public class SonyLeg implements Leg {
    public void go() {
        System.out.println(getClass().getSimpleName()+" is helping you to move ahead!");
    }
}
