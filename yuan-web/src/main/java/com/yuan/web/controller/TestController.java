package com.yuan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("t1")
	@ResponseBody
	public String t1(){
		JSONObject jo = new JSONObject();
		jo.put("code", "200");
		jo.put("msg", "success");
		return jo.toJSONString();
	}
}
