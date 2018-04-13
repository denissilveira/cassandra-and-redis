package com.poc.cassandraandredis.service;

import com.poc.cassandraandredis.model.entity.User;

public interface UserService {
	
	void sendMessageCreateUser(final User user);
	
	void createUser(final User user);

}