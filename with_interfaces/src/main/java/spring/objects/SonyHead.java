package spring.objects;// Created by Neginskiy Gregoriy.

import spring.interfaces.Head;

public class SonyHead implements Head {
    public void calc() {
        System.out.println(this.getClass().getSimpleName()+" is calculating...");
    }
}
