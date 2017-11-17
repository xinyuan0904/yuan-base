package com.yuan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.yuan.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	private final static Logger LOG = LoggerFactory.getLogger(UserController.class);
	private final static Logger LOG1 = LoggerFactory.getLogger("MONITOR");
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	@ResponseBody
	public String getUserList(){
		LOG.info("获取用户列表");
		LOG.error("获取失败");
		LOG1.error("asdfsdf");
		return JSONArray.toJSONString(userService.getUserList());
	}
}
