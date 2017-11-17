package com.yuan.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.db.dao.IUserDao;

//指定Junit的Runner
@RunWith(SpringJUnit4ClassRunner.class)
//指明配置文件所在
@ContextConfiguration(locations="classpath:spring-core.xml")
//指定事务管理器
@Transactional(transactionManager="transactionManager")
public class UserTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private IUserDao userDao;
	
	@Test
	public void test(){
		System.out.println(userDao.getUserList());
	}
	
}
