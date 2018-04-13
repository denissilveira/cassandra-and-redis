package com.poc.cassandraandredis.jms.consumer;

import static com.poc.cassandraandredis.config.ActiveMQConfig.CREATE_USER_QUEUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.poc.cassandraandredis.model.entity.User;
import com.poc.cassandraandredis.service.UserService;

@Component
public class UserConsumer {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService service;
    
    public UserConsumer(final UserService service) {
		this.service = service;
	}

	@JmsListener(destination = CREATE_USER_QUEUE)
    public void receiveMessage(final @Payload User user) {
        
        try {
        	service.createUser(user);
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
        }
    }

}