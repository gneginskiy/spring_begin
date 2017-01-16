package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class SampleLogger {
    public void printValue(Object obj) {
        System.out.println(obj);
    }

    public void init(){
        System.out.println("init");
    }

    public void handle(){
        System.out.println("SOMETHING WENT WRONG! Interceptor noticed it.");
    }

    public void watchTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(System.currentTimeMillis());
        pjp.proceed();
        System.out.println(System.currentTimeMillis());
    }


    public void close(){
        System.out.println("close");
    }

}
