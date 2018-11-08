package com.matmazur.springaopintro.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

@Aspect
@Component
public class TimeLoggerAspect {

    @Around("within(com.matmazur.springaopintro.repository.*)")
    public Object execTimemeasure(ProceedingJoinPoint pjp) {
        System.out.println("LOG - BEFORE");
        Instant before = Instant.now();

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

}
