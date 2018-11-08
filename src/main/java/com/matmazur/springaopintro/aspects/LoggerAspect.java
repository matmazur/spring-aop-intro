package com.matmazur.springaopintro.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* com.matmazur.springaopintro.repository.PersonRepository.*(..))")
    public void logInfoBefore(){
        System.out.println("Logged before");
    }


    @After("execution(* com.matmazur.springaopintro.repository.PersonRepository.*(..))")
    public void logInfoAfter(){
        System.out.println("Logged after");
    }



    @AfterThrowing("within(com.matmazur.springaopintro.repository.*)")
    public void logError(){
        System.out.println("Method thrown an exception");
    }


    @AfterReturning("within(com.matmazur.springaopintro.repository.*)")
    public void logSuccess(){
        System.out.println("Method finished with a success");
    }
}
