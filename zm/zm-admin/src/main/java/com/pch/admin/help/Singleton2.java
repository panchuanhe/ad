package com.pch.admin.help;

/**
 * 懒加载模式,且线程安全
 */
public class Singleton2 {

    private static volatile Singleton2 singleton2 = null;

    private Singleton2() {
    }

    public Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    synchronized (Singleton2.class) {
                        singleton2 = new Singleton2();
                    }
                }
            }
        }
        return singleton2;
    }
}
