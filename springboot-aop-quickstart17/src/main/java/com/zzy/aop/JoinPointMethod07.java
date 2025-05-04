package com.zzy.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class JoinPointMethod07 {


    @Around("@annotation(com.zzy.anno.JPExecutionAnno)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        1.get target object name(class name)
        String className = pjp.getTarget().getClass().getName();
        log.info("className is : {}",className);
//        2.1get target method signature
        Signature signature = pjp.getSignature();
//        2.2 from signature get the method name
        String methodName = signature.getName();
        log.info("methodName is : {}",methodName);
//        3.get arguments in the methods
        Object[] args = pjp.getArgs();
        log.info("args are : {}", args);

        Object result = pjp.proceed();

        return result;
    }
}
