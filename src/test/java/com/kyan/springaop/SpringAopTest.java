package com.kyan.springaop;

import com.kyan.springaop.dao.OrderDao;
import com.kyan.springaop.dao.ProductDao;
import com.kyan.springaop.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kyan
 * @date 2019/10/30
 */
public class SpringAopTest {

    /**
     * 利用自己定义的方法创建代理来实现AOP
     */
    @Test
    public void testAopWithProxy() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        UserDao userDao = (UserDao)ctx.getBean("proxy");
        System.out.println(userDao);
        userDao.save();
    }

    @Test
    public void testAopWithAspectJDKProxy() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        System.out.println(userDao.getClass());
        userDao.save();
        //class com.sun.proxy.$Proxy14
        //开始事务...
        //添加新用户
        //关闭事务...
    }

    @Test
    public void testAopWithAspectCglibProxy() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
        System.out.println(orderDao.getClass());
        orderDao.save();
        //class com.kyan.springaop.dao.OrderDao$$EnhancerBySpringCGLIB$$6545db2f
        //开始事务...
        //添加新订单
        //关闭事务...
    }

    @Test
    public void testAopWithPointCut() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
        System.out.println(orderDao.getClass());
        orderDao.save();
        //class com.kyan.springaop.dao.OrderDao$$EnhancerBySpringCGLIB$$3cc90b65
        //事务开始=====
        //添加新订单
        //事务结束=====
    }

    @Test
    public void testAopWithAnnotation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        ProductDao productDao = (ProductDao) ctx.getBean("productDao");
        System.out.println(productDao.getClass());
        productDao.save();
        //class com.kyan.springaop.dao.ProductDao$$EnhancerBySpringCGLIB$$989267ff
        //log before
        //add new product
        //log after
    }
}
