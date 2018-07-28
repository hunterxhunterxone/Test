package com.zzz.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.UserDao;
import com.zzz.entity.User;
import com.zzz.service.UserService;
@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return userDao.findUserList();
	}
	@Override
	public User selectUserByKey(User user) {
		// TODO Auto-generated method stub
		return userDao.selectUserByKey(user);
	}
	@Override
	public int insertTourist(User user) {
		// TODO Auto-generated method stub
		return userDao.insertSelective(user);
	}
	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKeySelective(record);
	}
}
