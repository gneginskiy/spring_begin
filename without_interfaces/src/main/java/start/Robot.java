package start;// Created by Neginskiy Gregoriy.

import impl.SonyHand;
import impl.SonyHead;
import impl.SonyLeg;

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
