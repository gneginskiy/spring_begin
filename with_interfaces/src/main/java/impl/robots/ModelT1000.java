package impl.robots;// Created by Neginskiy Gregoriy.

import interfaces.AbstractRobot;
import interfaces.parts.Hand;
import interfaces.parts.Head;
import interfaces.parts.Leg;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ModelT1000 extends AbstractRobot implements DisposableBean,InitializingBean{
    private String color;
    private int year;
    private boolean isSoundEnabled;

    public ModelT1000() {
    }

    public ModelT1000(Head head, Hand hand, Leg leg) {
        super(head,hand,leg);
    }

    public ModelT1000(Head head, Hand hand, Leg leg, String color, int year, boolean isSoundEnabled) {
        super(head,hand,leg);
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
        getHead().calc();
        getHand().catchSomething();
        getLeg().go();
        System.out.println("T1000 will destroy everything!");
    }

    @Override
    public void dance() {
        System.out.println("T1000 is dancing right now!");
        System.out.println("color is "+color+" year is "+year+" and sound is "+(isSoundEnabled?"enabled!":"disabled!"));
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

    public void destroy() {
        System.out.println(getClass().getSimpleName()+" is being destroyed "+this);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName()+" is being created "+this);
    }
}
