package com.kyan.springaop.bean;

import java.util.Date;

/**
 * 封装异常信息的类
 * @author kyan
 * @date 2019/11/1
 */
public class ExceptionMonitor {

    private String className;
    private String methodName;
    private Date logTime;       //异常记录时间
    private String message;     //异常信息

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionMonitor{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", logTime=" + logTime +
                ", message='" + message + '\'' +
                '}';
    }
}
