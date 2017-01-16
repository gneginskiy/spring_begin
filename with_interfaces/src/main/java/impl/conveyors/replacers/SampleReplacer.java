package impl.conveyors.replacers;// Created by Neginskiy Gregoriy.

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class SampleReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("replacer method has been called instead of  "+o+method.getName());
        return null;
    }
}
