package impl.parts.sony;// Created by Neginskiy Gregoriy.

import interfaces.parts.Head;

public class SonyHead implements Head {
    public void calc() {
        System.out.println(this.getClass().getSimpleName()+" is calculating...");
    }
}
