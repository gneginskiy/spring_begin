package start;// Created by Neginskiy Gregoriy.

import impl.robots.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ModelT1000 t1000 = context.getBean(ModelT1000.class);
        sleep(2);
        t1000.action();
        t1000.dance();
    }

    private static void sleep(int countSeconds) {
        try {
            Thread.sleep(countSeconds*countSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
