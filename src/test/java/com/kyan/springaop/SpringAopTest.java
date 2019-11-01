package com.kyan.springaop;

import com.kyan.springaop.dao.OrderDao;
import com.kyan.springaop.dao.ProductDao;
import com.kyan.springaop.dao.UserDao;
import com.kyan.springaop.service.UserService;
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

    @Test
    public void testAopMonitorTime() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login();
        //开始执行: com.kyan.springaop.service.UserServiceImpl#login
        //模拟用户登录
        //结束执行: com.kyan.springaop.service.UserServiceImpl#login
        //MonitorTime{className='com.kyan.springaop.service.UserServiceImpl', methodName='login', logTime=Fri Nov 01 15:53:52 CST 2019, consumeTime=1004}
    }

    @Test
    public void testAopMonitorException() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.doSomethingWrong();
        //模拟抛出异常
        //ExceptionMonitor{className='com.kyan.springaop.service.UserServiceImpl', methodName='null', logTime=Fri Nov 01 16:09:42 CST 2019, message='java.lang.ArithmeticException: / by zero'}
    }
}
