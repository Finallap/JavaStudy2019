package com.service;

/**
 * @description: JedisService
 * @date: 2020/5/18 12:39
 * @author: Finallap
 * @version: 1.0
 */
public interface JedisService {
    /**
     * set存数据
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * 取数据
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效期
     *
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    boolean remove(String key);
}
