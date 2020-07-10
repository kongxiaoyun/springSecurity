package com.kxy.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kxy.utils.RedisUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Configuration
public class RedisConfig {
	@Bean
	
	    @SuppressWarnings("all")
	
	    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
	
	        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	
	        template.setConnectionFactory(factory);
	
	        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
	
	        ObjectMapper om = new ObjectMapper();
	
	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	
	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	
	        jackson2JsonRedisSerializer.setObjectMapper(om);
	
	        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
	
	        // key采用String的序列化方式
	
	        template.setKeySerializer(stringRedisSerializer);
	
	        // hash的key也采用String的序列化方式
	
	        template.setHashKeySerializer(stringRedisSerializer);
	
	        // value序列化方式采用jackson
	
	        template.setValueSerializer(jackson2JsonRedisSerializer);
	
	        // hash的value序列化方式采用jackson
	
	        template.setHashValueSerializer(jackson2JsonRedisSerializer);
	
	        template.afterPropertiesSet();
	
	        return template;
	
	    }
	
	/**
     * 注入封装RedisTemplate
    * @Title: redisUtil 
    * @return RedisUtil
    * @autor lpl
    * @date 2017年12月21日
    * @throws
     */
    @Bean(name = "redisUtil")
    public RedisUtil redisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }

}
