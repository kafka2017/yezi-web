package cn.com.yezi.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import cn.com.yezi.util.FastJsonRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
		// 设置值（value）的序列化采用FastJsonRedisSerializer。
		redisTemplate.setValueSerializer(fastJsonRedisSerializer);
		redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
		// 设置键（key）的序列化采用StringRedisSerializer。
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
