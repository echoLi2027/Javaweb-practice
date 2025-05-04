package com.zzy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class TimeAspect {


    @Around("execution(public java.util.List com.zzy.service.impl.DeptServiceImpl.list())")
    Object processTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();

        log.info("list method runtime is : {} ms",(end-start));

        return result;

    }
}
