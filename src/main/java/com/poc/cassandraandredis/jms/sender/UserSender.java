package com.poc.cassandraandredis.jms.sender;

import static com.poc.cassandraandredis.config.ActiveMQConfig.CREATE_USER_QUEUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.poc.cassandraandredis.model.entity.User;

@Service
public class UserSender {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final User user) {
        logger.info("sending with convertAndSend() to queue transaction <" + user + ">");
        jmsTemplate.convertAndSend(CREATE_USER_QUEUE, user);
    }
}