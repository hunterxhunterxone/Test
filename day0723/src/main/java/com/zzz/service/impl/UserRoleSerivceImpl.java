package com.zzz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.UserRoleDao;
import com.zzz.entity.UserRole;
import com.zzz.service.UserRoleService;
@Service(value="userRoleService")
public class UserRoleSerivceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	@Override
	public int insert(UserRole record) {
		// TODO Auto-generated method stub
		return userRoleDao.insert(record);
	}
	
}
