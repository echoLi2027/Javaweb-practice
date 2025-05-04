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
@Order(2)
@Component
public class JoinPointExecution05 {

//    @Around("execution(com.zzy.pojo.Dept com.zzy.service.impl.DeptServiceImpl.getById(java.lang.Integer))")
//    @Around("execution(* com.zzy..*.getById(..))")
//    @Around("execution(* com.zzy.service.*.*.getById(..))")
//    @Around("execution(* com.zzy..*.getById(..))")
//    @Around("execution(* com.zzy.service.*.*(java.lang.Integer))")
//    @Around("execution(* com.zzy.service.impl.DeptServiceImpl.*(*))")
//    @Around("execution(* com.zzy.service.impl.DeptServiceImpl.*e(*))")
//    @Around("execution(* com.zzy..*.*(..))")
    @Around("execution(* com.zzy.service.DeptService.list(..)) ||" +
            "execution(* com.zzy.service.DeptService.delete(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("before AspectExecuteOrder04.....");

        Object result = pjp.proceed();

        log.info("after AspectExecuteOrder04.....");

        return result;
    }
}
