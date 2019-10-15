package com.zhyyu.learn.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author juror
 * @datatime 2019/10/14 16:24
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);
        long startMillis = System.currentTimeMillis();

        rateLimiter.acquire();
        System.out.println(rateLimiter.tryAcquire());
//        rateLimiter.acquire();

        System.out.println("used millis: " + (System.currentTimeMillis() - startMillis));
    }

}
