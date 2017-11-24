package com.yuan.web;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.yuan.service.UserService;
import com.yuan.service.redis.RedisService;

import redis.clients.jedis.Jedis;

public class RedisTest extends AbstractTest{

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		 System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        jedis.set("sss", "2222");
        
        jedis.lpush("list", "l1");
        jedis.lpush("list", "l2");
     // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
        
        List<String> l = jedis.lrange("list", 0, 2);
        for(int i=0; i<l.size(); i++) {
            System.out.println("列表项为: "+l.get(i));
        }
        
        Jedis je = new Jedis("redis.milibx.com");
        je.auth("mili_bxbb_123");
        System.out.println(je.ping());
        je.quit();
	}
	@Autowired
	private RedisService redisService;
	
	@Test
	public void test(){
//		redisService.set("name", "22222");
		redisService.setByOps("age", "11");
		System.out.println("====="+redisService.getRedisByKey("sss"));
//		System.out.println("====="+redisService.getFromOpsByKey("age"));
		
	}
}
