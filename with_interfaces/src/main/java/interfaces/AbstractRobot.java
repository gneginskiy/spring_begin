package interfaces;// Created by Neginskiy Gregoriy.

import interfaces.parts.Hand;
import interfaces.parts.Head;
import interfaces.parts.Leg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.inject.Named;

public class AbstractRobot implements IRobot {
    public AbstractRobot(Head head, Hand hand, Leg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    @Inject
    @Named("sonyHead")
    private Head head;

    @Inject
    @Qualifier("toshibaHand") //lol. it's also possible.
    private Hand hand;

    @Autowired
    @Qualifier("toshibaLeg")
    private Leg leg;

    public AbstractRobot() {
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

}
