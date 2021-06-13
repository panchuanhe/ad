package com.pch.admin.proxy;

import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class UserManagerImpl implements UserManager {


    @Override
    public void addUser() {
        System.out.println("目标方法，添加用户");
    }

    public static void main(String[] args) {
//        JdkProxy jdkProxy = new JdkProxy();
//        UserManager userManager = (UserManager)jdkProxy.getProxy(new UserManagerImpl());
//        userManager.addUser();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger);



//        CglibProxy cglibProxy = new CglibProxy();
//        UserManager proxy = (UserManager)cglibProxy.getProxy(new UserManagerImpl());
//        proxy.addUser();

    }
}
