package cn.you.jedisspringboot.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @Author: linxinmin
 * @Date: 2019/3/1 20:42
 */
@Configuration
public class JedisCondfig {
    @Bean
    public RedisTemplate<Serializable, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Serializable, Object> template = new RedisTemplate<Serializable, Object>();
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        // redis存取对象的关键配置
        template.setKeySerializer(new StringRedisSerializer());
        // ObjectRedisSerializer类为java对象的序列化和反序列化工具类
        template.setValueSerializer(new ObjectRedisSerializer());
        return template;
    }
}
