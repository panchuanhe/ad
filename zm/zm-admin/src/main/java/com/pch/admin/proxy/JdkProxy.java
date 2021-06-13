package com.pch.admin.proxy;

import org.springframework.web.method.support.InvocableHandlerMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在目标方法之前加入小名");
        Object invoke = method.invoke(object, args);
        System.out.println("在目标方法之前加入小张");
        return invoke;
    }

    public Object getProxy(Object targetObject) {
        this.object = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }
}
