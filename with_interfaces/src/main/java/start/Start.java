package start;// Created by Neginskiy Gregoriy.

import impl.conveyors.T1000Conveyor;
import interfaces.AbstractRobotConveyor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.CommonUtils;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        AbstractRobotConveyor t1000Conveyor = context.getBean("t1000Conveyor", T1000Conveyor.class);

        t1000Conveyor.createRobotUsingReplacedMethod();
        //ModelT1000 t1000 = context.getBean(ModelT1000.class); //can be ambigious if we declare multiple beans with matching type
        //ModelT1000 t1000 = context.getBean("t1000",ModelT1000.class);
        //ModelT1000 t1000Other = context.getBean("t1000",ModelT1000.class);

        //System.out.println(t1000);
        //System.out.println(t1000Other);
        CommonUtils.sleep(2);
        //t1000.action();
        //t1000.dance();
    }


}
