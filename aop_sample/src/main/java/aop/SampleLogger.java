package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

import static aop.MiscUtils.printArgs;

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

    @Around("allMethods() && execution(java.util.Map *(..))*")
    public Object watchTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP Apect invocation is starting : "+System.currentTimeMillis());
        System.out.println("\nProceeding with |"+ joinPoint.getSignature()+"|\n");
        joinPoint.proceed();
        MiscUtils.printArgs(joinPoint);
        System.out.println("AOP Apect invocation is finishing : "+System.currentTimeMillis());
        return null;
    }

    @SuppressWarnings("rawtypes")
    @AfterReturning(pointcut = "execution(java.util.HashMap *(..))", returning = "map")
    public void printReturnedMap(JoinPoint jp, Object map){
        System.out.println("Printing map from joinpoint: "+map);
    }

    @SuppressWarnings("rawtypes")
    @AfterReturning(pointcut = "execution(java.util.Set *(..))", returning = "set")
    public void printReturnedSet(JoinPoint jp, Object set){
        System.out.println("Printing set from joinpoint: "+set);
    }

    @SuppressWarnings("rawtypes")
    @AfterReturning(value  = "execution(java.lang.String *(..))", returning = "str")
    public void printReturnedString(JoinPoint jp, Object str){
        System.out.println("AOP feature which is supposed to print returned value from joinpoint: "+str);
    }

    public void printReturnedSet(){

    }


    public void close(){
        System.out.println("close");
    }



}
