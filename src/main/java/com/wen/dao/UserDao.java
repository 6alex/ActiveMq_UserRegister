package com.wen.dao;

import com.wen.po.User;

public interface UserDao {
	void addUser(User user);
	int updateUser(User user);
}
