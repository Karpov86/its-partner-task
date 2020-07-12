package by.karpov.ITSPartnertask.aspect;

import by.karpov.ITSPartnertask.database.entity.Lamp;
import by.karpov.ITSPartnertask.database.entity.Room;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* by.karpov.ITSPartnertask.service.RoomServiceImpl.getAll())")
    public void callAtMyRoomServiceGetAll() {
    }

    @Pointcut("execution(* by.karpov.ITSPartnertask.service.RoomServiceImpl.*(..))")
    public void callAtMyRoomServicePublic() {
    }

    @Pointcut("@annotation(AspectAnnotation)")
    public void callAtMyLampServicePublic() {
    }

    @Before("callAtMyLampServicePublic()")
    public void beforeCallLampServiceMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before {}, args=[{}]", jp.getSignature(), args);
    }

    @AfterReturning(pointcut = "callAtMyLampServicePublic()", returning = "result")
    public void afterReturningCallAt(JoinPoint jp, Lamp result) {
        log.info("method name: {}, return value: {}", jp.getSignature().getName(), result);
    }

    @Before("callAtMyRoomServicePublic()")
    public void beforeCallRoomServiceMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before {}, args=[{}]", jp.getSignature(), args);
    }

    @AfterReturning(pointcut = "callAtMyRoomServicePublic()", returning = "result")
    public void afterReturningCallAt(JoinPoint jp, Room result) {
        log.info("method name: {}, return value: {}", jp.getSignature().getName(), result);
    }

    @AfterReturning(pointcut = "callAtMyRoomServiceGetAll()", returning = "list")
    public void afterReturningCallAt(JoinPoint jp, List<Room> list) {
        log.info("method name: {}, list size: {}", jp.getSignature().getName(), list.size());
    }

}
