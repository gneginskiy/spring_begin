package impl.conveyors;// Created by Neginskiy Gregoriy.

import interfaces.AbstractRobot;
import interfaces.AbstractRobotConveyor;

public abstract class T1000Conveyor implements AbstractRobotConveyor{
    @Override
    public abstract AbstractRobot createRobot() ;

    @Override
    public abstract AbstractRobot createRobotUsingReplacedMethod();
}
