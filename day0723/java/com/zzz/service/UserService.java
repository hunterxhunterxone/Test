package com.zzz.service;

import java.util.List;

import com.zzz.entity.User;

public interface UserService {
	List<User> findUserList();
	User selectUserByKey(User user);
	int insertTourist(User user);
	int updateByPrimaryKeySelective(User record);
}
