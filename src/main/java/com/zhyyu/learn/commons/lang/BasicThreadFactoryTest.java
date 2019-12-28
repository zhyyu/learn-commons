package com.zhyyu.learn.commons.lang;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author juror
 * @datatime 2019/12/28 17:39
 */
public class BasicThreadFactoryTest {

    private static ThreadLocal myThreadLocal = new ThreadLocal();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new MyThreadFactory());

        myThreadLocal.set(9);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello " + Thread.currentThread().getName());
            }
        });
    }

    private static class MyThreadFactory implements ThreadFactory {

        private ThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("myThreadPool-%d").build();

        @Override
        public Thread newThread(Runnable r) {
            return threadFactory.newThread(new MyRunnable(r, (int) myThreadLocal.get()));
        }
    }

    private static class MyRunnable implements Runnable {

        private Runnable runnable;
        private int mdcId;

        public MyRunnable(Runnable runnable, int mdcId) {
            this.runnable = runnable;
            this.mdcId = mdcId;
        }

        @Override
        public void run() {
            System.out.println(mdcId);
            runnable.run();
        }
    }

}
