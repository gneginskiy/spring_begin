package impl.parts.toshiba;// Created by Neginskiy Gregoriy.

import interfaces.parts.Leg;

public class ToshibaLeg implements Leg {
    public void go() {
        System.out.println(getClass().getSimpleName()+" is helping you to move ahead!");
    }
}
