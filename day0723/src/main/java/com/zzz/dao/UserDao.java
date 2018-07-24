package com.zzz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zzz.entity.User;

public interface UserDao {
	List<User> findUserList();
	User selectUserByKey(User user);
}
