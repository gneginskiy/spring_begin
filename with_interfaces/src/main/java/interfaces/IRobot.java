package interfaces;// Created by Neginskiy Gregoriy.

public interface IRobot {
    default void action(){
        System.out.println("Action of your robot hasn't specified yet");
    };
    default void dance(){
        System.out.println("Dancing procedure of your robot hasn't specified yet");
    };
}
