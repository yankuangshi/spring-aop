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
@Aspect
@Component
public class Aop3 {

    @Pointcut("@annotation(LogManage)")
    public void pt(){}

    @Before("pt()")
    public void logBefore() {
        System.out.println("log before");
    }

    @After("pt()")
    public void logAfter() {
        System.out.println("log after");
    }

}
