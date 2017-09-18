package com.lai;

import com.lai.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot4ApplicationTests {

	//测试Redis——string类型
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {

	}

	@Test
	public void test() throws Exception
	{
		//保存字符串
		stringRedisTemplate.opsForValue().set("aaa","11111");
		Assert.assertEquals("11111",stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	@Test
	public void test2() throws  Exception{
		User user=new User("超人",20);
		redisTemplate.opsForValue().set(user.getUsername(),user);
		user = new User("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new User("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(30,redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(40,redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
	}
}
