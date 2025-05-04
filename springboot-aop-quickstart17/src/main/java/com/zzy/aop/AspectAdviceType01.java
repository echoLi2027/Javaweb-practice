package com.zzy.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Order(1)
@Component
public class AspectAdviceType01 {


    @Pointcut("execution(* com.zzy.controller.*.*(..))")
    private void pt(){};

    @Before("pt()")
    public void before(){
        log.info("before aspect......");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before ProceedingJoinPoint.....");

        Object result = pjp.proceed();

        log.info("after ProceedingJoinPoint.....");

        return result;
    }

    @After("pt()")
    public void after(){
        log.info("after aspect(will execute no matter there is error)......");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("after aspect(will execute only the method returns without exception)......");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("after aspect(will execute only the method return has exception)......");
    }
}
