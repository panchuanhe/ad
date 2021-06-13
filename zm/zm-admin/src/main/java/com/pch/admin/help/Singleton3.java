package com.pch.admin.help;

/**
 * 线程安全,累不累
 */
public class Singleton3 {

    private static class B {
        private static final Singleton3 singleton3 = new Singleton3();
    }


    public Singleton3 getInstance() {
        return B.singleton3;
    }
}
