package com.yuan.web.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;  
		try {
			System.out.println("收到消息："+tm.getText());;
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
