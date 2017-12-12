package com.yuan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yuan.service.mq.QueueSenderService;

/**
 * 
 * @ClassName MqController
 * @author YUAN
 * @date 2017年12月13日
 * @version 1.0
 */
@Controller
@RequestMapping("mq")
public class MqController {

	@Autowired
	private QueueSenderService queueSenderService;
	
	@RequestMapping("send")
	@ResponseBody
	public String send(String msg){
		JSONObject jo = new JSONObject();
		queueSenderService.send(msg);
		System.out.println("发送消息:"+msg);
		jo.put("code", 200);
		return jo.toJSONString();
	}
}
