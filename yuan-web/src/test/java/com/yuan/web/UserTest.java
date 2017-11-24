package com.yuan.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuan.db.dao.IUserDao;
import com.yuan.service.UserService;

//指定Junit的Runner
@RunWith(SpringJUnit4ClassRunner.class)
//指明配置文件所在
@ContextConfiguration(locations={"classpath:spring-core.xml","classpath:spring-mvc.xml"})
//指定事务管理器
@Transactional(transactionManager="transactionManager")
public class UserTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private UserService userSerivce;
	@Test
	public void test(){
		System.out.println(JSONArray.toJSON(userSerivce.getUserList()));
	}
	
	
}
