package cn.you.jedisspringboot.redis;//package cn.jpa.springbootjpa.redis;
//
//import redis.clients.jedis.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: linxinmin
// * @Date: 2019/3/1 20:05
// */
//public class TestJedis {
//
//    private Jedis jedis;//非切片额客户端连接
//    private JedisPool jedisPool;//非切片连接池
//    private ShardedJedis shardedJedis;//切片额客户端连接
//    private ShardedJedisPool shardedJedisPool;//切片连接池
//
//    public RedisClient()
//    {
//        initialPool();
//        initialShardedPool();
//        shardedJedis = shardedJedisPool.getResource();
//        jedis = jedisPool.getResource();
//
//
//    }
//
//    /**
//     * 初始化非切片池
//     */
//    private void initialPool()
//    {
//        // 池基本配置
//        JedisPoolConfig config = new JedisPoolConfig();
////        config.setMaxActive(20);
//        config.setMaxIdle(5);
//        config.setMaxWaitMillis(1000*2);
//        config.setTestOnBorrow(false);
//
//        jedisPool = new JedisPool(config,"127.0.0.1",6379);
//    }
//
//    /**
//     * 初始化切片池
//     */
//    private void initialShardedPool()
//    {
//        // 池基本配置
//        JedisPoolConfig config = new JedisPoolConfig();
////        config.setMaxActive(20);
//        config.setMaxIdle(5);
//        config.setMaxWaitMillis(1000*2);
//        config.setTestOnBorrow(false);
//        // slave链接
//        List<JedisShardInfo> shards = new ArrayList<>();
//        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));
//
//        // 构造池
//        shardedJedisPool = new ShardedJedisPool(config, shards);
//    }
//
//    public void show() {
//        KeyOperate();
//        StringOperate();
//        ListOperate();
//        SetOperate();
//        SortedSetOperate();
//        HashOperate();
////        jedisPool.returnResource(jedis);
////        shardedJedisPool.returnResource(shardedJedis);
//        jedisPool.getResource();
//        shardedJedisPool.getResource();
//    }
//
//    private void KeyOperate() {
//
//    }
//
//    private void StringOperate() {
//
//    }
//
//    private void ListOperate() {
//    }
//
//    private void SetOperate() {
//    }
//
//    private void SortedSetOperate() {
//    }
//
//    private void HashOperate() {
//    }
//
//}
