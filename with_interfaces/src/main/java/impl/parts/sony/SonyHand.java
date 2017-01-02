package impl.parts.sony;// Created by Neginskiy Gregoriy.

import interfaces.parts.Hand;

public class SonyHand implements Hand {
    public void catchSomething() {
        System.out.println(getClass().getSimpleName()+" is catching something");
    }
}
