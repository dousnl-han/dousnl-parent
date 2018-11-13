package com.dousnl.service;

import com.dousnl.domain.TPermission;

public interface TPermissionService {

	int insert(TPermission record);
	
	TPermission selectByPrimaryKey(int id, int roleId);
	
	TPermission selectByRoleKey(int roleId);
}
