package com.zzz.service;


import java.util.List;

import com.zzz.entity.Role;

public interface RoleService {
	public Role selectByKey(Integer id);
	public List<Role> selectByUserEmail(String email);
}
