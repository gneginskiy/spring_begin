package impl.robots;// Created by Neginskiy Gregoriy.

import interfaces.AbstractRobot;
import interfaces.parts.Hand;
import interfaces.parts.Head;
import interfaces.parts.Leg;

public class SimpleRobot extends AbstractRobot {
    public SimpleRobot(Head head, Hand hand, Leg leg) {
        super(head, hand, leg);
    }

    public void action(){
        getHead().calc();
        getHand().catchSomething();
        getLeg().go();

    }

}
