package spring;// Created by Neginskiy Gregoriy.

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostprocessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("-------------------------------------------------------------BeanPostprocessor before " + o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("-------------------------------------------------------------BeanPostprocessor after " + o);
        return o;
    }
}
