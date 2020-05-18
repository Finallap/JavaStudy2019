package com.service;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description: JedisImpl
 * @date: 2020/5/18 12:43
 * @author: Finallap
 * @version: 1.0
 */
@Service("jedisService")
public class JedisServiceImpl implements JedisService {
    @Resource
    private RedisTemplate<String, ?> redisTemplate;

    /**
     * set存数据
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(String key, String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();
                redisConnection.set(stringRedisSerializer.serialize(key), stringRedisSerializer.serialize(value));
                return true;
            }
        });

        return result;
    }

    /**
     * 取数据
     *
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] values = redisConnection.get(serializer.serialize(key));
                String result = serializer.deserialize(values);
                return result;
            }
        });
        return result;
    }

    /**
     * 设置有效期
     *
     * @param key
     * @param expire
     * @return
     */
    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    @Override
    public boolean remove(String key) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.del(key.getBytes());
                return true;
            }
        });
        return result;
    }
}
