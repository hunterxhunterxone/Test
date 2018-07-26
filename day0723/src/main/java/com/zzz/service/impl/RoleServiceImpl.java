package com.zzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzz.dao.RoleDao;
import com.zzz.entity.Role;
import com.zzz.service.RoleService;
@Service(value="roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public Role selectByKey(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.selectByPrimaryKey(id);
	}

}
