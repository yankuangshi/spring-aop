package com.kyan.springaop.aop;

import java.lang.annotation.*;

/**
 * @author kyan
 * @date 2019/11/1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimerManage {
}
