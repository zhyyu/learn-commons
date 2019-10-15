package com.zhyyu.learn.guava.cachebuilder;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @author juror
 * @datatime 2019/10/14 18:28
 */
public class CacheBuilderTest {

    public static void main(String[] args) throws InterruptedException {

        /*ConcurrentMap<String, String> map = CacheBuilder.newBuilder().maximumSize(100_0000L)
                .expireAfterWrite(5, TimeUnit.SECONDS).<String, String>build().asMap();

        map.put("1", "a");
        while (true) {
            System.out.println(map.get("1"));
        }*/

        LoadingCache<String, RateLimiter> loadingCache = CacheBuilder.newBuilder().build(new CacheLoader<String, RateLimiter>() {
            @Override
            public RateLimiter load(String key) throws Exception {
                RateLimiter rateLimiter = RateLimiter.create(1);
                System.out.println("hashCode: " + rateLimiter.hashCode());
                return rateLimiter;
            }
        });

        System.out.println(loadingCache.getIfPresent("1"));
        System.out.println(loadingCache.getIfPresent("1"));
        System.out.println(loadingCache.getUnchecked("1"));
        System.out.println(loadingCache.getIfPresent("1"));

        loadingCache.getUnchecked("2");
    }

}
