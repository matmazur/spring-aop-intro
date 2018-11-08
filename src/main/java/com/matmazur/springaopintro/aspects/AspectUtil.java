package com.matmazur.springaopintro.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {

    @Pointcut("execution(* com.matmazur.springaopintro.repository.PersonRepository.*(..))")
    public void allBookRepoMethods(){}

}
