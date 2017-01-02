package spring.start;// Created by Neginskiy Gregoriy.

import spring.objects.SonyHand;
import spring.objects.SonyHead;
import spring.objects.SonyLeg;

public class Robot{
    private SonyHead head = new SonyHead();
    private SonyLeg leg = new SonyLeg();
    private SonyHand hand = new SonyHand();

    public void action(){
        head.calc();
        hand.catchSomething();
        leg.go();
    }

}
