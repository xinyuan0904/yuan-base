package com.yuan.service.mq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 消息
 * @ClassName QueueSender
 * @author YUAN
 * @date 2017年12月13日
 * @version 1.0
 */
@Service
public class QueueSenderService {

	@Autowired
	private JmsTemplate jmsQueueTemplate;
	
	public void send(){
//		jmsQueueTemplate.getDefaultDestination().toString();
//		jmsQueueTemplate.setDefaultDestinationName("QueueSenderService");
		jmsQueueTemplate.send(new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("猜测鹅鹅鹅");
			}
			
		});
	}
	public void send(final String msg){
//		jmsQueueTemplate.getDefaultDestination().toString();
//		jmsQueueTemplate.setDefaultDestinationName("QueueSenderService");
		jmsQueueTemplate.send(new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
			
		});
	}
}
