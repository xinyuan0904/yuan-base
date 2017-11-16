package com.yuan.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yuan.db.pojo.User;
@Repository
public interface IUserDao {

	List<User> getUserList();
}
