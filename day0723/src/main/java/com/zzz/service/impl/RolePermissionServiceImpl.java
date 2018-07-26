package com.zzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.RolePermissionDao;
import com.zzz.entity.RolePermission;
import com.zzz.service.RolePermissionService;
@Service(value="rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Override
	public List<RolePermission> selectByKey(Integer id) {
		// TODO Auto-generated method stub
		return rolePermissionDao.selectRolePermissionByKey(id);
	}

}
