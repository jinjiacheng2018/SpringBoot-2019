package com.tgram.sboot.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *<p> Description: 缓存配置类 </p>
 *<p> Copyright: Copyright(c) 2019/1/17 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/17 14:26
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 获取密钥生成器
     * @return KeyGenerator
     */
    //@Bean
    public KeyGenerator keyGenerator(){
        return  new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(target.getClass().getName());
                stringBuilder.append(method.getName());
                for (Object param : params) {
                    stringBuilder.append(param.toString());
                }
                return stringBuilder.toString();
            }
        };
    }

    /**
     * 获取缓存管理器
     * @param redisTemplate
     * @return
     */
    //@SuppressWarnings("rawtypes")
    //@Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate)
    {
        //RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        return null;
    }
}
