package com.yuan.service.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 获取redisTemplate
 * @ClassName RedisGeneratorDao
 * @author YUAN
 * @date 2017年11月20日
 * @version 1.0
 * @param <K>
 * @param <V>
 */
public class RedisGeneratorDao<K extends Serializable,V extends Serializable> {
	
	@Autowired
	protected RedisTemplate<K,V> redisTemplate;

	public RedisTemplate<K, V> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	  /**
	   * 获取 RedisSerializer
	   */ 
	  protected RedisSerializer<String> getRedisSerializer() { 
	    return redisTemplate.getStringSerializer(); 
	  }
}

