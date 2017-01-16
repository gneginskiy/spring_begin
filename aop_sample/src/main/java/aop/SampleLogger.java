package aop;

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


    public void close(){
        System.out.println("close");
    }

}
