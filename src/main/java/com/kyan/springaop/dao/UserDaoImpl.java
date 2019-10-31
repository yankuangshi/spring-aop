package com.kyan.springaop.dao;

import org.springframework.stereotype.Component;

/**
 * @author kyan
 * @date 2019/10/30
 */
@Component(value = "userDao")
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("添加新用户");
    }
}
