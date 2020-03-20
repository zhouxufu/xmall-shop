package com.xmall.third.biz.counter;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 滑动窗口计数器
 * redis 根据时间进行滑动窗口
 *
 * @author zhouxufu
 */
@Component
public class RedisSlidingWindowCounter {

    private final RedisTemplate<String, Integer> redisTemplate;

    private ConcurrentHashMap<String, Long> timeWindowSizeMap = new ConcurrentHashMap<>();

    public RedisSlidingWindowCounter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long setTimeWindowSize(String counterName, long windowSecondSize) {
        return timeWindowSizeMap.put(counterName, windowSecondSize);
    }


    /**
     * 获取当前计数器 数字
     *
     * @param key
     * @return
     */
    public int count(String key) {
        ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
        Integer count = valueOperations.get(key);
        return count != null ? count : 0;
    }

//    /**
//     * 当前计数器进行自增
//     *
//     * @return
//     */
//    public int incr(String key) {
//        ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
//        valueOperations.setIfAbsent(key, 1, );
//    }


}
