package com.example.weixin.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxRedisConfig {

    @Value("${spring.redis.database:12}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout:1000}")
    private int timeout;

//    @Bean
//    public JedisPool redisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(maxTotal);
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMinIdle(minIdle);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
//        return jedisPool;
//    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setDatabase(database)
                .setPassword(password)
        .setConnectionMinimumIdleSize(10)
        ;
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }

}
