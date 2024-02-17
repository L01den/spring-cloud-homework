package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by Lorden on 04.02.2024
 */

@Slf4j
@Aspect
@Component
public class TimerAspect {

    @Pointcut("within(@com.example.demo.Timer *)")
    public void beansAnnotatedWith() {
    }

    @Pointcut("@annotation(com.example.demo.Timer)")
    public void methodsAnnotatedWith() {
    }

    @Around("beansAnnotatedWith() || methodsAnnotatedWith()")
    public void measurement(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();

        log.info("target = {}, method = {}, time = {}",
                joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), elapsed);
    }
}
