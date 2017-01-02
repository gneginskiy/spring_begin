package impl.robots;// Created by Neginskiy Gregoriy.

import interfaces.parts.Hand;
import interfaces.parts.Head;
import interfaces.parts.Leg;
import interfaces.AbstractRobot;

public class SimpleRobot implements AbstractRobot {
    private Head head;
    private Leg leg;
    private Hand hand;

    public SimpleRobot(Head head, Leg leg, Hand hand) {
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
