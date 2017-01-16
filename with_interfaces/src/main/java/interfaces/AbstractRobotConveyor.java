package interfaces;// Created by Neginskiy Gregoriy.

public interface AbstractRobotConveyor {
    //configured in context XML-file to return different instance every single call using lookup-method
    public abstract AbstractRobot createRobot();
    //dynamic method substitution using CGLIB feature
    public abstract AbstractRobot createRobotUsingReplacedMethod();

}
