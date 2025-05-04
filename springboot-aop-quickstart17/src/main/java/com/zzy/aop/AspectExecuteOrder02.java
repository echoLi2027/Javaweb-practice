package com.zzy.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Order(4)
@Component
public class AspectExecuteOrder02 {


    @Pointcut("execution(* com.zzy.controller.*.*(..))")
    private void pt(){};

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before AspectExecuteOrder02.....");

        Object result = pjp.proceed();

        log.info("after AspectExecuteOrder02.....");

        return result;
    }
}
