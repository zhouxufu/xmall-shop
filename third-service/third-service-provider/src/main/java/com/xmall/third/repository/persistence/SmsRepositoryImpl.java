package com.xmall.third.repository.persistence;

import com.xmall.third.repository.contants.PrefixConstants;
import com.xmall.third.repository.facade.SmsRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouxufu
 */
@Repository
public class SmsRepositoryImpl implements SmsRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public SmsRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveVerifyCode(String verifyScope, String phone, String verifyCode, Long expireSecond) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(PrefixConstants.SMS_VERIFY_CODE + verifyScope + phone, verifyCode, expireSecond, TimeUnit.SECONDS);
    }

    @Override
    public String getVerifyCode(String verifyScope, String phone) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(PrefixConstants.SMS_VERIFY_CODE + verifyScope + phone);
    }
}
