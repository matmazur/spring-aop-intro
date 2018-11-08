package com.matmazur.springaopintro.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {



    @Before("execution(* com.matmazur.springaopintro.repository.PersonRepository.*(..))")
    public void logInfoBefore(){
        System.out.println("Logged before");
    }


}
