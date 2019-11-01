package com.kyan.springaop.service;

import com.kyan.springaop.aop.TimerManage;
import org.springframework.stereotype.Component;

/**
 * @author kyan
 * @date 2019/11/1
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService {

    @TimerManage
    public void login() {
        System.out.println("模拟用户登录");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void doSomethingWrong() {
        System.out.println("模拟抛出异常");
        int r = 100 / 0;
    }
}
