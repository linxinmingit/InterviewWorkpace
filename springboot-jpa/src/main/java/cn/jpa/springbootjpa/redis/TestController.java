package cn.jpa.springbootjpa.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class TestController {
 
    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;
 
    @RequestMapping("/set")
    public String setPOJO(){
 
        JedisObject object = new JedisObject();
        object.setAddress("湖南永州");
        object.setAge("150");
        object.setId(11);
        object.setName("降央左马");
        redisTemplate.opsForValue().set("user1", object);
        return "存储对象";
    }
 
    @RequestMapping("/get")
    public Object getPOJO(){
        return redisTemplate.opsForValue().get("user1");
    }
 
}
