package cn.com.taiji.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class cont {
	@Autowired
	RedisService rs;
	
	@RequestMapping("/show")
	public String test() {
		return "insertData";
	}
	
	@RequestMapping("/adduser")
	public String addUser(User user) {
		rs.mapTest(user);
		return "success";
	}
	
	@RequestMapping("/showdata")
	public String showData() {
		
		return "insertData";
	}
}
