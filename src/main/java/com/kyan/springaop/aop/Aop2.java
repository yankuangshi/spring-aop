package com.kyan.springaop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author kyan
 * @date 2019/10/30
 */
@Component
@Aspect
public class Aop2 {

    @Pointcut("execution(* com.kyan.springaop.dao.OrderDao.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void begin() {
        System.out.println("事务开始=====");
    }

    @After("pointCut()")
    public void close() {
        System.out.println("事务结束=====");
    }

}
