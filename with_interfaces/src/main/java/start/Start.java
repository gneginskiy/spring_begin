package start;// Created by Neginskiy Gregoriy.

import impl.pools.T1000Pool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.CommonUtils;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        T1000Pool t1000Pool = context.getBean("t1000Pool", T1000Pool.class);
        t1000Pool.actionAll();


        //t1000Conveyor.createRobotUsingReplacedMethod();
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
