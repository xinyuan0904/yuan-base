package com.yuan.service.dubbo;

import java.util.ArrayList;
import java.util.List;

import com.yuan.db.pojo.User;
import com.yuan.dubbo.IDubboService;

public class DubboServiceImpl implements IDubboService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;  
	}

	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>(); 
		User u1 = new User();
		u1.setName("zhangs");
		User u2 = new User();
		u2.setName("lis");
		list.add(u1);
		list.add(u2);
		return list;
	}

}
