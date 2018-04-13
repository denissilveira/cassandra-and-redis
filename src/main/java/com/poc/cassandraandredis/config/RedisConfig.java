package com.poc.cassandraandredis.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

//    @Bean
//    public CacheManager cacheManager(final RedisConnectionFactory connectionFactory) {
//
//        RedisCacheConfiguration config = RedisCacheConfiguration
//                                            .defaultCacheConfig()
//                                            .entryTtl(Duration.ofSeconds(180))
//                                            .disableCachingNullValues();
//
//        final RedisCacheManager cacheManager = RedisCacheManager
//                                                .builder(connectionFactory)
//                                                .cacheDefaults(config)
//                                                .transactionAware()
//                                                .build();
//        return cacheManager;
//    }
}