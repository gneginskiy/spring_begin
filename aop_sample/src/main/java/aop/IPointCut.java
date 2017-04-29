package aop;// Created by Neginskiy Gregoriy.

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface IPointCut {
    public void doSomething();

    HashMap doSmthWithMap();

    Set doSmthWithSet();

    String doSmthWithString();
}
