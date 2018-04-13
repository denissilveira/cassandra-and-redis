package com.poc.cassandraandredis.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.cassandraandredis.jms.sender.UserSender;
import com.poc.cassandraandredis.model.entity.User;
import com.poc.cassandraandredis.repository.UserRepository;
import com.poc.cassandraandredis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final UserSender sender;
	
	public UserServiceImpl(final UserRepository repository, final UserSender sender) {
		this.repository = repository;
		this.sender = sender;
	}

	@Async
	@Override
	public void sendMessageCreateUser(final User user) {
		sender.send(user);
	}

	@Transactional
	@Override
	public void createUser(final User user) {
		repository.save(user);
	}

}
