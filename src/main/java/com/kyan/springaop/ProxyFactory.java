package com.kyan.springaop;

import com.kyan.springaop.aop.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kyan
 * @date 2019/10/30
 */
public class ProxyFactory {

    private static Object target;
    private static Aop aop;

    public static Object getProxyInstance(Object _target, Aop _aop) {
        target = _target;
        aop = _aop;

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop.begin();
                        Object returnValue = method.invoke(target, args);
                        aop.close();

                        return returnValue;
                    }
                }
        );
    }
}
