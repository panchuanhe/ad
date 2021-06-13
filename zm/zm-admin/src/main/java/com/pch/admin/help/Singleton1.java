package com.pch.admin.help;

/**
 * 饱汉模式
 */
public class Singleton1 {
    private static final Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public Singleton1 getInstance() {
        return singleton1;
    }
}
