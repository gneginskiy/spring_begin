package impl.parts.toshiba;// Created by Neginskiy Gregoriy.

import interfaces.parts.Hand;

public class ToshibaHand implements Hand {
    public void catchSomething() {
        System.out.println(getClass().getSimpleName()+" is catching something");
    }
}
