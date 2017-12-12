package com.yuan.web.mq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuan.service.mq.QueueReceiverService;
import com.yuan.service.mq.QueueSenderService;
import com.yuan.web.AbstractTest;

public class MqTest extends AbstractTest{

	@Autowired
	private QueueSenderService queueSenderService;
	
//	@Test
	public void test(){
		try {
			queueSenderService.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("发送完成");
	}
	@Autowired
	private QueueReceiverService queueReceiverService;
	
	@Test
	public void receive(){
		queueReceiverService.receive();
	}
}
