package com.zzy.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Order(3)
@Component
public class AspectExecuteOrder03 {


    @Pointcut("execution(* com.zzy.controller.*.*(..))")
    private void pt(){};

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before AspectExecuteOrder03.....");

        Object result = pjp.proceed();

        log.info("after AspectExecuteOrder03.....");

        return result;
    }
}
