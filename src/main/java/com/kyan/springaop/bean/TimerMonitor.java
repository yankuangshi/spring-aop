package com.kyan.springaop.bean;

import java.util.Date;

/**
 * 封装性能监控信息类
 * @author kyan
 * @date 2019/11/1
 */
public class TimerMonitor {

    private String className;
    private String methodName;
    private Date logTime;
    private long consumeTime;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(long consumeTime) {
        this.consumeTime = consumeTime;
    }

    @Override
    public String toString() {
        return "MonitorTime{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", logTime=" + logTime +
                ", consumeTime=" + consumeTime +
                '}';
    }
}
