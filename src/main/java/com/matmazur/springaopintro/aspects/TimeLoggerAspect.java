package com.matmazur.springaopintro.aspects;

import com.matmazur.springaopintro.model.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

@Aspect
@Component
public class TimeLoggerAspect {

    @Around("within(com.matmazur.springaopintro.repository.*)")
    public Object execTimemeasure(ProceedingJoinPoint pjp) {

        Instant before = Instant.now();
        Object[] args = pjp.getArgs();
        System.out.printf("LOG before %s with args %s\n", pjp.getSignature(), Arrays.toString(args));

        try {

            Thread.sleep(new Random().nextInt(4000));


            Object result = pjp.proceed();
            System.out.println("LOG - AFTER");
            return result;


        } catch (Throwable throwable) {
            System.out.println("LOG - AFTER THROWING");
            throwable.printStackTrace();

        } finally {
            System.out.println("LOG - AFTER RETURNING");


            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms\n", pjp.toShortString(), execTime.toMillis());
        }
        return null;
    }


    @AfterReturning(pointcut = "execution(* com.matmazur.springaopintro.repository.PersonRepository.getById(..)) && args(id)", returning = "result")
    public void logSuccess(JoinPoint point, Long id, Person result) {
        System.out.printf("Method get() successfully returned value %s for isbn %s\n", result, id);

        System.out.println(result.getName());
    }


}
