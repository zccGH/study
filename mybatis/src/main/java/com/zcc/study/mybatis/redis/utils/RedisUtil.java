package com.zcc.study.mybatis.redis.utils;

import com.zcc.study.mybatis.redis.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName RedisUtil
 * @Description: redis工具类
 * @Author chengcheng.zhao01
 * @Date 2020/11/23
 * @Version V1.0
 **/
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 根据key判断是否存在
     * @param key
     * @return
     */
    public boolean haskey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Component
    public class RedisList{

        /**
         * 获取list缓存的内容
         * @param key
         * @param start
         * @param end
         * @return
         */
        public List<?> get(String key, Long start, Long end){
            try {
                return redisTemplate.opsForList().range(key, start, end);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * 将list集合数据放入缓存
         * @param key
         * @param value
         * @return
         */
        public boolean set(String key,Object value){
            try {
                redisTemplate.opsForList().rightPush(key, value);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
