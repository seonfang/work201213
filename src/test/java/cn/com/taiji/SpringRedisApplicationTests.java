package cn.com.taiji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.redis.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {
	@Autowired
	RedisService redisService;
	
	@Test
	public void contextLoads() {
		
		redisService.test();
	}

}
