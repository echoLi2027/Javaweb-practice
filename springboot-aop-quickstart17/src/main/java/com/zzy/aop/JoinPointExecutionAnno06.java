package com.zzy.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class JoinPointExecutionAnno06 {


    @Around("@annotation(com.zzy.anno.JPExecutionAnno)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before AspectExecuteOrder04.....");

        Object result = pjp.proceed();

        log.info("after AspectExecuteOrder04.....");

        return result;
    }
}
