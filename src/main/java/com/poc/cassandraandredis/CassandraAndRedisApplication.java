package com.poc.cassandraandredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CassandraAndRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraAndRedisApplication.class, args);
	}
}
