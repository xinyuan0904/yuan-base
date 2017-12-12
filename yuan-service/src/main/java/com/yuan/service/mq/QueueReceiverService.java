package com.yuan.service.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueReceiverService {

	@Autowired
	private JmsTemplate jmsQueueTemplate;
	
	public void receive(){
		System.out.println(jmsQueueTemplate.receive());
	}
}
