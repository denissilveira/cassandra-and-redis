package com.poc.cassandraandredis.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.poc.cassandraandredis.model.entity.User;

public interface UserRepository extends CrudRepository<User, UUID> {

    Iterable<User> findByAge(final int age);
    
    Iterable<User> findByName(final String name);
}