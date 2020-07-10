package by.karpov.ITSPartnertask.aspect;

import by.karpov.ITSPartnertask.database.entity.Room;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    /*@Pointcut("execution(* by.karpov.ITSPartnertask.service.RoomServiceImpl.*(..))")
    public void callAtMyServicePublic(){}*/

    @Pointcut("execution(* by.karpov.ITSPartnertask.service.RoomServiceImpl.getAll())")
    public void callAtMyServiceGetAll(){}

    @Pointcut("execution(* by.karpov.ITSPartnertask.service.RoomServiceImpl.*(..))")
    public void callAtMyServicePublic(){}

    /*@Before("callAtMyServicePublic()")
    public void logMethodCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        //logger.log(Level.INFO, "method name:" + methodName);
        log.info("method name: {}", methodName);
    }*/

    @Before("callAtMyServicePublic()")
    public void beforeCallMethod(JoinPoint jp){
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before {}, args=[{}]", jp.getSignature().getName(), args);
    }

    @AfterReturning(pointcut = "callAtMyServicePublic()", returning = "result")
    public void afterReturningCallAt(JoinPoint jp, Room result){
        log.info("method name: {}, return value: {}", jp.getSignature().getName(), result);
    }

    @AfterReturning(pointcut = "callAtMyServiceGetAll()", returning = "list")
    public void afterReturningCallAt(JoinPoint jp, List<Room> list){
        log.info("method name: {}, list size: {}", jp.getSignature().getName(), list.size());
    }

}
