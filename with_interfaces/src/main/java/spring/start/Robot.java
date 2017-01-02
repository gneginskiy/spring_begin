package spring.start;// Created by Neginskiy Gregoriy.

import spring.interfaces.Hand;
import spring.interfaces.Head;
import spring.interfaces.Leg;

public class Robot{
    private Head head;
    private Leg leg;
    private Hand hand;

    public Robot(Head head, Leg leg, Hand hand) {
        this.head = head;
        this.leg = leg;
        this.hand = hand;
    }

    public void action(){
        head.calc();
        hand.catchSomething();
        leg.go();

    }

}
