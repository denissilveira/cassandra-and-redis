package com.poc.cassandraandredis.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(final RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration config = RedisCacheConfiguration
                                            .defaultCacheConfig()
                                            .entryTtl(Duration.ofSeconds(10))
                                            .disableCachingNullValues();

        final RedisCacheManager cacheManager = RedisCacheManager
                                                .builder(connectionFactory)
                                                .cacheDefaults(config)
                                                .transactionAware()
                                                .build();
        return cacheManager;
    }
}