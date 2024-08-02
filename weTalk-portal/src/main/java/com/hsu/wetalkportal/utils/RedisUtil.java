package com.hsu.wetalkportal.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * @author zhouxq
 * @date 2019/8/6
 */
@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 自增
     */
    public Object incr(String key,int value){
        return key == null ? null : redisTemplate.opsForValue().increment(key,value);
    }

    /**
     * 缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 缓存获取
     *
     * @param key 键 不能为null
     * @param clazz 类
     * @return 值
     */
    public <T> T get(String key, Class<T> clazz) {
        String json = (String) redisTemplate.opsForValue().get(key);
        try {
            if (StringUtils.isNotEmpty(json)) {
                return JSONObject.parseObject(json, clazz);
            }
        } catch (Exception e) {
            log.error("获取(解析)缓存数据异常", e);
        }

        return null;
    }

    /**
     * 缓存放入
     *
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("放入缓存异常" + e.getMessage());
            return false;
        }
    }

    /**
     *  删除指定缓存
     * @param key 缓存key
     * @return
     */
    public boolean delete(String key){
        try {
            return redisTemplate.delete(key);
        } catch (Exception e) {
            log.error("放入缓存异常" + e.getMessage());
            return false;
        }
    }

    /**
     *  删除指定缓存
     * @param key 缓存key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("查询缓存异常" + e.getMessage());
            return false;
        }
    }

    /**
     * 缓存放入并设置时间
     *
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("放入缓存异常" + e.getMessage());
            return false;
        }
    }

    // ================================Map=================================

    /**
     * HashGet
     *
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public Object hGet(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * HashGet
     *
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     */
    public <T> T hGet(String key, String item, Class<T> clazz) {
        String json = (String) redisTemplate.opsForHash().get(key, item);
        try {
            if (StringUtils.isNotEmpty(json)) {
                return new GsonBuilder().create().fromJson(json, clazz);
            }
        } catch (Exception e) {
            log.error("获取(解析)缓存数据异常", e);
        }

        return null;
    }

    /**
     * HashGet 获取所有
     *
     * @param key 键 不能为null
     * @return 值
     */
    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hSet(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            log.error("Redis操作异常", e);
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hSet(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("Redis操作异常", e);
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hDel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     *
     * @param key 键
     * @param item 项
     * @param by 要增加几(大于0)
     * @return
     */
    public double hIncr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     *
     * @param key 键
     * @param item 项
     * @param by 要减少记(小于0)
     * @return
     */
    public double hDecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /**
     * 指定缓存失效时间
     *
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("Redis操作异常", e);
            return false;
        }
    }

    /**
     * 缓存放入并设置缓存在某一时期过期
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean setExpireAt(String key, Object value, Date date) {
        try {
            redisTemplate.opsForValue().set(key, value);
            if (ObjectUtils.isEmpty(date)) {
                redisTemplate.expireAt(key, date);
            }
            return true;
        } catch (Exception e) {
            log.error("放入缓存异常" + e.getMessage());
            return false;
        }
    }

    /**
     * 指定缓存失效时间
     *
     * @param key 键
     * @return
     */
    public Long getExpire(String key, TimeUnit timeUnit) {
        try {
            return redisTemplate.getExpire(key, timeUnit);
        } catch (Exception e) {
            log.error("Redis操作异常", e);
            return null;
        }
    }
    public Long getExpires(String keyt) {
        try {
           return redisTemplate.opsForValue().getOperations().getExpire(keyt);
        } catch (Exception e) {
            log.error("Redis操作异常", e);
            return null;
        }
    }



}


