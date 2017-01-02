package spring.objects;// Created by Neginskiy Gregoriy.

import spring.interfaces.Hand;

public class ToshibaHand implements Hand {
    public void catchSomething() {
        System.out.println(getClass().getSimpleName()+" is catching something");
    }
}
