package com.dousnl.api.service;

import com.dousnl.api.domain.TPermission;

public interface TPermissionService {

	int insert(TPermission record);
	
	TPermission selectByPrimaryKey(int id, int roleId);
	
	TPermission selectByRoleKey(int roleId);
}
