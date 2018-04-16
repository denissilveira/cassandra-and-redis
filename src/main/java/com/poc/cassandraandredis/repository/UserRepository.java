package com.poc.cassandraandredis.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import com.poc.cassandraandredis.model.entity.User;

public interface UserRepository extends CrudRepository<User, UUID> {

	@AllowFiltering
    Iterable<User> findByAge(final int age);
    
    @AllowFiltering
    Iterable<User> findByName(final String name);
}