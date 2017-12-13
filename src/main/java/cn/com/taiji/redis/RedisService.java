package cn.com.taiji.redis;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	public String test() {
		String uuid = UUID.randomUUID().toString();
		
//		redisTemplate.opsForValue().set(uuid, "测试", 1000);
// 		redisTemplate.opsForValue().set("aaa", "123");
//		redisTemplate.opsForList().set("AA", 10, "BB");
//		Set s= new HashSet<>();
//		s.add("aA");
//		s.add("Bb");
//		redisTemplate.opsForSet();
		return "";
	}
	
	public void listTest(User user) {
		 //添加 一个 list 列表
	    ListOperations<String, Object> list = redisTemplate.opsForList();
	    list.rightPush("ttList",user);
	   
//	    System.out.println(list.range("lpList", 0, 1));
//		return "list";
	}
	public String mapTest(User u) {
		 //添加 一个 set 集合
	    SetOperations<String, Object> set  = redisTemplate.opsForSet();
	    set.add("tSet", u.getNo());
	    set.add("tSet", u.getName());
	    set.add("tSet", u.getSex());
	    //输出 set 集合
//	    System.out.println(set.members("lpSet"));
		return "";
	}
	public void addU(User user) {
		redisTemplate.opsForSet().add(user.getNo(), user);
	}
}
