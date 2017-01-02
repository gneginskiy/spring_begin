package spring.start;// Created by Neginskiy Gregoriy.

import spring.objects.SonyHead;
import spring.objects.SonyLeg;
import spring.objects.ToshibaHand;

public class RobotManager {
    public static void main(String[] args) {
        new Robot(new SonyHead(),new SonyLeg(),new ToshibaHand()).action();
    }
}
