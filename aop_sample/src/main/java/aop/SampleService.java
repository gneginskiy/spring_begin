package aop;

import org.springframework.stereotype.Component;

@Component
public class SampleService {
    public int getIntValue(){
        if (true) {
            throw new RuntimeException("!!!!!!!!!!!!!!AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
        return 123;
    }

    public void processEverything(){
        System.out.println("processing everything");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public double getDoubleValue(){
        return 456.789;
    }
}
