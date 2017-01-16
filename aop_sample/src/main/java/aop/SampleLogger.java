package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class SampleLogger {
    public void printValue(Object obj) {
        System.out.println(obj);
    }

    @Pointcut("execution(* aop.IPointCut.*(..))")
    private void allMethods() {
    };

    public void init(){
        System.out.println("init");
    }

    public void handle(){
        System.out.println("SOMETHING WENT WRONG! Interceptor noticed it.");
    }

    @Around("allMethods()")
    public Object watchTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(System.currentTimeMillis());
        System.out.println(pjp.getSignature());
        pjp.proceed();
        System.out.println(System.currentTimeMillis());
        return null;
    }


    public void close(){
        System.out.println("close");
    }

}
