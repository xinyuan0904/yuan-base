package com.yuan.dubbo;

import java.util.List;

import com.yuan.db.pojo.User;

public interface IDubboService {

	String sayHello(String name);
	
	List<User> getUsers();
}
