package com.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description: CustomCacheKey
 * @date: 2020/5/19 15:46
 * @author: Finallap
 * @version: 1.0
 */
@Slf4j
@Component("customCacheKeyGenerator")
public class CustomCacheKeyGenerator implements KeyGenerator {
    /**
     * Generate a key for the given method and its parameters.
     *
     * @param target the target instance
     * @param method the method being called
     * @param params the method parameters (with any var-args expanded)
     * @return a generated key
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        log.info("call CustomCacheKey:" + target.getClass().getSimpleName() + " " + method.getName() + " " + params[0]);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(target.getClass().getSimpleName()).
                append("_").
                append(method.getName()).
                append("_").
                append(params[0]);

        return stringBuffer.toString();
    }
}
