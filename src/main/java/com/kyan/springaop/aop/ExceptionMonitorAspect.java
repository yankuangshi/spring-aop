package com.kyan.springaop.aop;

import com.kyan.springaop.bean.ExceptionMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author kyan
 * @date 2019/11/1
 */
@Component
@Aspect
public class ExceptionMonitorAspect {

    @Pointcut("execution(* com.kyan.springaop.service.UserService.*(..))")
    void pt() {}

    @Around("pt()")
    public Object logException(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            ExceptionMonitor info = new ExceptionMonitor();
            info.setClassName(joinPoint.getTarget().getClass().getName());
            info.setMessage(joinPoint.getSignature().getName());
            info.setLogTime(new Date());
            info.setMessage(e.toString());
            System.out.println(info);
        }
        return null;
    }
}
