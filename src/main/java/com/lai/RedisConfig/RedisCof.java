package com.lai.RedisConfig;

import com.lai.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by lailai on 2017/9/18.
 * 配置针对对象的RedisTemplate实例
 */
@Configuration
public class RedisCof<T> {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return  new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, T> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,T> template=new RedisTemplate<>();
        //factory会在注入的时候读取配置文件生成对应的redisConnectionFactory
        template.setConnectionFactory(factory); //不用上面生成的JedisConnectionFactory
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return  template;
    }
}
