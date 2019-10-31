package com.kyan.springaop.dao;

import com.kyan.springaop.aop.LogManage;
import org.springframework.stereotype.Component;

/**
 * @author kyan
 * @date 2019/10/30
 */
@Component
public class ProductDao {

    @LogManage
    public void save() {
        System.out.println("add new product");
    }
}
