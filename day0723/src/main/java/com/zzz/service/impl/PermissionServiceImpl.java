package com.zzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.PermissionsDao;
import com.zzz.entity.Permissions;
import com.zzz.service.PermissionService;
@Service(value="permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionsDao permissionDao;
	@Override
	public Permissions selectByKey(Integer id) {
		// TODO Auto-generated method stub
		return permissionDao.selectByPrimaryKey(id);
	}

}
