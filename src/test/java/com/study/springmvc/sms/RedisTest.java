package com.study.springmvc.sms;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.study.springmvc.base.BaseTest;

public class RedisTest extends BaseTest{
	@Autowired
	private RedisTemplate<String, String> template;
	
	@Resource(name="redisTemplate")
	private ListOperations<String, String> listOps;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	  
	@Before
	public void setContext(){
		System.out.println("init");
	}
	@After
	public void doClose(){
		System.out.println("close");
	}
	
	@Test
	public void testRedis() {
		try {
			Set<String>set=template.keys("*");
			System.out.println("success"+set.size());
			BoundValueOperations<String, String> s=stringRedisTemplate.boundValueOps("test2");
			System.out.println(s.get());
			System.out.println(s.getType());
			System.out.println(s.getKey());
			System.out.println(template.boundValueOps("test2").get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
