package com.netcracker.solution.aoplogger.aspect;


import com.netcracker.solution.aoplogger.exception.ResourceNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;


import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(com.netcracker.solution.aoplogger.annotation.Auditable)")
    public void loggableMethods() {
    }

    @Around("loggableMethods()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Entering in Method :  " + joinPoint.getSignature().getName());
        log.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
        try {
            log.info("response : " + joinPoint.proceed());
            Object proceed = joinPoint.proceed();
            return joinPoint.proceed();
        } catch (ResourceNotFoundException e) {
            log.info("exception is : " + e.getMessage());
            return e;
        }
    }
}

