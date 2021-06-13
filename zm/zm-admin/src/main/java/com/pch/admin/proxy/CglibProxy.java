package com.pch.admin.proxy;


import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object object;


    public Object getProxy(Object targetObject) {
        this.object = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("在目标方法前添加1111");
        Object invoke = method.invoke(object, objects);
        System.out.println("在目标方法前添加2222");
        return invoke;
    }
}
