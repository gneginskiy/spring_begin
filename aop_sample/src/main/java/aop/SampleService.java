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

    public double getDoubleValue(){
        return 456.789;
    }
}
