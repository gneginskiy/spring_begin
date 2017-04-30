package aop;// Created by Neginskiy Gregoriy.

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class PointCutSample implements IPointCut {

    public void doSomething() {
        System.out.println("doing something great! "+this);
    }

    @Override
    public HashMap doSmthWithMap() {
        HashMap map = new HashMap<>();
        map.put("sampleKey1","sampleValue1");
        map.put("sampleKey2","sampleValue2");
        map.put("sampleKey3","sampleValue3");
        return map;
    }

    @Override
    public Set doSmthWithSet() {
        Set set = new HashSet<>();
        set.add("sampleValue1");
        set.add("sampleValue2");
        set.add("sampleValue3");
        return set;
    }

    @Override
    public String doSmthWithString() {
        Map<String, String> map = new HashMap<>();
        return "sampleStringIsHere!";
    }

    @Override
    public void doSmthWithReceivedStrValue(String value) {
        System.out.println(
                "DOING SOMETHING EXTREMELY USEFUL WITH RECEIVED STRING VALUE! For instance, we're gonna print it! "
                        +value);
    }
}
