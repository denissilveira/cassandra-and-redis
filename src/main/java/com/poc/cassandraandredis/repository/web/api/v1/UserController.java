package com.poc.cassandraandredis.repository.web.api.v1;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import com.poc.cassandraandredis.model.entity.User;
import com.poc.cassandraandredis.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    @Cacheable(value = "users")
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        System.out.println("Get all users...");
        return repository.findAll();
    }
    
    @PostMapping("/users/create")
    public User createCustomer(@Valid @RequestBody User user) {
        System.out.println("Create user: " + user.getName() + "...");
        user.setId(UUIDs.timeBased());
        return repository.save(user);
    }
    
    @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
    @GetMapping("/user/{userId}")
    public Optional<User> findById(@PathVariable String userId) {
        return repository.findById(UUID.fromString(userId));
    }
    
    @GetMapping("/users/findbyage")
    public Iterable<User> findByAge(@RequestParam int age) {
        return repository.findByAge(age);
    }
    
    @GetMapping("/users/findbyname")
    public Iterable<User> findByName(@RequestParam String name) {
        return repository.findByName(name);
    }

}
