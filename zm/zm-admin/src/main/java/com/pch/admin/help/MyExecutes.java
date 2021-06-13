package com.pch.admin.help;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 手写线程池
 */
public class MyExecutes {

    private BlockingDeque<Runnable> blockingDeque;

    public MyExecutes(int cores, int maxThread) {
        blockingDeque = new LinkedBlockingDeque<>(maxThread);
        for (int i = 0; i < cores; i++) {
            new Thread(new WorkThread()).start();
        }
    }

    public void execute(Runnable runnable) {
        blockingDeque.add(runnable);
    }

    class WorkThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                Runnable poll = blockingDeque.poll();
                if (poll != null)
                    poll.run();
            }
        }
    }

    public static void main(String[] args) {
        MyExecutes myExecutes = new MyExecutes(2, 10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myExecutes.execute(() -> System.out.println(Thread.currentThread().getName() + "," + finalI));

        }
    }
}
