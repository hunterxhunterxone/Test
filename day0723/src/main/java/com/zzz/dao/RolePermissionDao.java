package com.zzz.dao;

import java.util.List;

import javax.annotation.Resource;

import com.zzz.entity.RolePermission;

public interface RolePermissionDao {
	List<RolePermission> selectRolePermissionByKey(Integer id);
}
