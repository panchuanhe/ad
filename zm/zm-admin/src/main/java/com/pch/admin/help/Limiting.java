package com.pch.admin.help;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * 限流
 */
public class Limiting {

    //令牌桶，每2秒生产十个令牌
    RateLimiter rateLimiter = RateLimiter.create(2, 2, TimeUnit.SECONDS);


    private void test1() {
        if (rateLimiter.tryAcquire()) {
            System.out.println("获得令牌，执行业务方法");
        } else {
            System.out.println("没有获得令牌，返回失败");
        }
    }


    public static void main(String[] args) {

    }

    private static void test3() {
        System.out.println("222222222222222");
    }

    /**
     * 一个球从100米高度自由落下，每次落地后反跳回原高度的一半再落下。求它在第10次落地时，共经过多少米，第10次反弹多高。
     *
     * @param height
     * @param i
     */
    private static void test2(int height, int i) {

        int haf = height / 2;
        if (i == 10) {
            System.out.println(haf);
            return;
        }
        test2(haf, i + 1);
    }

    private static class Demo {
        private void doWork(Task task){
//            task.run();
            System.out.println("dowork被执行了");
        }
    }

    private static abstract class Task {
        public abstract void run();
    }
}
