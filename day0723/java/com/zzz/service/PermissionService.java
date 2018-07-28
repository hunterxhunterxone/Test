package com.zzz.service;
import java.util.Set;

import com.zzz.entity.Permissions;

public interface PermissionService {
	public Permissions selectByKey(Integer id);
	public Set<Permissions> selectByRId(Integer rid);
}
