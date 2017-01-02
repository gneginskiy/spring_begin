package impl.parts.sony;// Created by Neginskiy Gregoriy.

import interfaces.parts.Leg;

public class SonyLeg implements Leg {
    public void go() {
        System.out.println(getClass().getSimpleName()+" is helping you to move ahead!");
    }
}
