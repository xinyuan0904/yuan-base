package com.yuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.db.dao.IUserDao;
import com.yuan.db.pojo.User;

@Service
public class UserService {

	@Autowired
	private IUserDao userDao;
	
	public List<User> getUserList(){
		return userDao.getUserList();
	}
}
