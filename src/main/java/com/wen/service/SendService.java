package com.wen.service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.wen.po.User;

@Service
public class SendService {
	@Resource
	JmsTemplate jmsTemplate;
	@Resource
	Queue queue;

	public void send(final User user) {
		jmsTemplate.send(queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(user);
			}
		});
	}
}
