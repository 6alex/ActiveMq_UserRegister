package com.wen.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wen.dao.UserDao;
import com.wen.po.User;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	UserDao userDao;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
		
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

}
