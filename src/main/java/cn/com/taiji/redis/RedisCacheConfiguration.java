package cn.com.taiji.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
@PropertySource("classpath:/redis.properties")
public class RedisCacheConfiguration extends CachingConfigurerSupport {

	Logger logger = LoggerFactory.getLogger(RedisCacheConfiguration.class);
	
	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;
	
	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;
	
	@Value("${spring.redis.password}")
	private String password;
	
	/**
	 * 
	 * @Description: 方法说明
	 * @return JedisConnectionFactory  
	 * @throws
	 * @author seon
	 * @date 2017年12月13日
	 */
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		
		jedisConnectionFactory.setHostName(host);
		jedisConnectionFactory.setPort(port);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		return jedisConnectionFactory;
	}
	/**
	 * 
	 * @Description: 方法说明
	 * @return StringRedisTemplate  
	 * @throws
	 * @author seon
	 * @date 2017年12月13日
	 */
	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	/**
	 * 
	 * @Description: 方法说明
	 * @return RedisTemplate<String,Object>  
	 * @throws
	 * @author seon
	 * @date 2017年12月13日
	 */
	@Bean
	public RedisTemplate<String,Object> redisTemplate() {
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	/**
	 * 
	 * @Description: 方法说明
	 * @return RedisCacheManager  
	 * @throws
	 * @author seon
	 * @date 2017年12月13日
	 */
	@Bean
	public RedisCacheManager name() {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
		
		cacheManager.setDefaultExpiration(timeout);
		cacheManager.setLoadRemoteCachesOnStartup(true);
		cacheManager.setUsePrefix(true);
		return cacheManager;
	}
	
}





