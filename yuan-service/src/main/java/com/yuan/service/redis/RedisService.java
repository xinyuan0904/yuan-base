package com.yuan.service.redis;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis处理
 * @ClassName RedisService
 * @date 2017年11月20日
 * @version 1.0
 */
@Service
public class RedisService{

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	/**
	 * 添加
	 * @MethodName add 
	 * @param key
	 * @param value
	 * @author YUAN
	 * @return void
	 */
	public void set(final String key,final String value){
		redisTemplate.execute( new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				((StringRedisConnection)connection).set(key, value);
//				connection.set(redisTemplate.getStringSerializer().serialize(key), 
//				redisTemplate.getStringSerializer().serialize(value));
				return true;
			}
		},false,true);
	}
	/**
	 * 添加
	 * @MethodName set 
	 * @param key
	 * @param value
	 * @param sec 过期时间
	 * @author YUAN
	 * @return void
	 */
	public void set(final String key,final String value,final long sec){
		redisTemplate.execute( new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				
				connection.setEx(redisTemplate.getStringSerializer().serialize(key), sec,
				redisTemplate.getStringSerializer().serialize(value));
				return true;
			}
		},false,true);
	}
	/**
	 * 根据key获取value
	 * @MethodName getRedisByKey 
	 * @param key
	 * @return
	 * @author YUAN
	 * @return String
	 */
	public String getRedisByKey(final String key){
		return redisTemplate.execute( new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				return ((StringRedisConnection)connection).get(key);
				//序列化key
//				byte[] keySer = redisTemplate.getStringSerializer().serialize(key);
//				byte[] value = connection.get(keySer);
//				if( value == null ){
//					return null;
//				}
//				return redisTemplate.getStringSerializer().deserialize(value);
				
			}
		},false,true);
	}
	public void setByOps(String key,String value){
		redisTemplate.opsForValue().set(key, value);
	}
	public List<String> getFromOpsByKey(final String key){
		BoundListOperations<String,String> bo = redisTemplate.boundListOps(key);
		final long size = bo.size();
		return bo.range(0, size);
	}
}
