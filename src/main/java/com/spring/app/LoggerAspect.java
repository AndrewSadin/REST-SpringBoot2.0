package com.spring.app;

import org.springframework.stereotype.Component;

@Component
public class LoggerAspect {

    public void printValue(Object obj){
        System.out.println(obj);
    }

    public void start(){
        System.out.println("Start");
    }

    public void end(){
        System.out.println("End");
    }
}
