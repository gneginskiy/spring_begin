package impl.robots;// Created by Neginskiy Gregoriy.

import interfaces.AbstractRobot;
import interfaces.parts.Hand;
import interfaces.parts.Head;
import interfaces.parts.Leg;

public class ModelT1000 implements AbstractRobot {
    private Head head;
    private Hand hand;
    private Leg leg;

    private String color;
    private int year;
    private boolean isSoundEnabled;

    public ModelT1000() {
    }

    public ModelT1000(Head head, Hand hand, Leg leg) {
        super();
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    public ModelT1000(Head head, Hand hand, Leg leg, String color, int year, boolean isSoundEnabled) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
        this.color = color;
        this.year = year;
        this.isSoundEnabled = isSoundEnabled;
    }

    public ModelT1000(String color, int year, boolean isSoundEnabled) {
        this.color = color;
        this.year = year;
        this.isSoundEnabled = isSoundEnabled;
    }

    @Override
    public void action() {
        head.calc();
        hand.catchSomething();
        leg.go();
        System.out.println("T1000 will destroy everything!");
    }

    @Override
    public void dance() {
        System.out.println("T1000 is dancing right now!");
        System.out.println("color is "+color+" year is "+year+" and sound is "+(isSoundEnabled?"enabled!":"disabled!"));
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnabled() {
        return isSoundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        isSoundEnabled = soundEnabled;
    }
}
