package com.kyan.springaop.aop;

import com.kyan.springaop.bean.TimerMonitor;
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
public class TimerMonitorAspect {

    @Pointcut("@annotation(TimerManage)")
    void timerPt() {}

    @Around("timerPt()")
    public Object logTimer(ProceedingJoinPoint joinPoint) throws Throwable {
        TimerMonitor timerMonitor = new TimerMonitor();
        //获取目标类名称
        String clazzName = joinPoint.getTarget().getClass().getName();
        //获取目标类方法名称
        String methodName = joinPoint.getSignature().getName();
        timerMonitor.setClassName(clazzName);
        timerMonitor.setMethodName(methodName);
        timerMonitor.setLogTime(new Date());

        long start = System.currentTimeMillis();
        System.out.println("开始执行: " + clazzName + "#" + methodName);
        Object result = joinPoint.proceed();
        System.out.println("结束执行: " + clazzName + "#" + methodName);
        long consumeTime = System.currentTimeMillis() - start;
        //设置消耗时间
        timerMonitor.setConsumeTime(consumeTime);
        //这里可以自己实现把MonitorTime记录上传给监控系统
        //例如MonitorUtils.report(monitorTime)
        System.out.println(timerMonitor);
        return result;
    }
}
