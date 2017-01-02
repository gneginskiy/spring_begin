package start;// Created by Neginskiy Gregoriy.

import impl.parts.sony.SonyHead;
import impl.parts.sony.SonyLeg;
import impl.parts.toshiba.ToshibaHand;
import impl.robots.SimpleRobot;

public class RobotManager {
    public static void main(String[] args) {
        new SimpleRobot(new SonyHead(),new SonyLeg(),new ToshibaHand()).action();
    }
}
