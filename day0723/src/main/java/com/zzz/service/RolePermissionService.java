package com.zzz.service;

import java.util.List;

import com.zzz.entity.RolePermission;

public interface RolePermissionService {
	List<RolePermission> selectByKey(Integer id);
}
