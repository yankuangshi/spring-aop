package com.kyan.springaop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author kyan
 * @date 2019/10/30
 */
@Component
@Aspect
public class Aop {

    @Before("execution(* com.kyan.springaop.dao.UserDao.*(..))")
    public void begin() {
        System.out.println("开始事务...");
    }

    @After("execution(* com.kyan.springaop.dao.UserDao.*(..))")
    public void close() {
        System.out.println("关闭事务...");
    }
}
