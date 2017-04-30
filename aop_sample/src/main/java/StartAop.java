import aop.IPointCut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartAop {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        IPointCut iPointCutImplementation = (IPointCut) context.getBean("pointCutSample");
        //iPointCutImplementation.doSomething();
        iPointCutImplementation.doSmthWithMap();
        iPointCutImplementation.doSmthWithReceivedStrValue("received string value!");

        //iPointCutImplementation.doSmthWithString();

    }
}
