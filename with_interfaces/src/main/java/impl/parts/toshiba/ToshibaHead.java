package impl.parts.toshiba;// Created by Neginskiy Gregoriy.

import interfaces.parts.Head;

public class ToshibaHead implements Head {
    public void calc() {
        System.out.println(this.getClass().getSimpleName()+" is calculating...");
    }
}
