package com.pch.admin.help;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        Thread.sleep(3000L);
        myThread.flag = false;
        System.out.println("主线程走完了");
    }

}

class MyThread implements Runnable {
    public volatile Boolean flag = true;

    @Override
    public void run() {
        System.out.println("进入子线程，开始");
        while (flag) {

        }
        System.out.println("进入子线程，结束");

    }
}
