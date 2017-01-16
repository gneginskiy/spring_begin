package impl.pools;// Created by Neginskiy Gregoriy.

import interfaces.AbstractRobot;
import interfaces.AbstractRobotPool;

import java.util.Collection;

public class T1000Pool implements AbstractRobotPool {


    private Collection<AbstractRobot> robotCollection;

    @Override
    public Collection<AbstractRobot> getRobotCollection() {
        return robotCollection  ;
    }

    public void setRobotCollection(Collection<AbstractRobot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    public void actionAll(){
        for (AbstractRobot robot : robotCollection) {
            robot.action();
        }
    }
}
