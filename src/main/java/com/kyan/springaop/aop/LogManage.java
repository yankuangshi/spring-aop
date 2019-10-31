package com.kyan.springaop.aop;

import java.lang.annotation.*;

/**
 * @author kyan
 * @date 2019/10/30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogManage {
}
