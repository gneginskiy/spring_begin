package aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by user on 30.04.2017.
 */
public final class MiscUtils {
    public static void printArgs(ProceedingJoinPoint joinPoint) {
        int argNumber = 0;
        for (Object argValue : joinPoint.getArgs()) {
            System.out.println("argValue#"+argNumber+" = "+argValue);
        }
    }
}
