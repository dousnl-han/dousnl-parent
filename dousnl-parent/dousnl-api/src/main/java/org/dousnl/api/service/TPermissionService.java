package org.dousnl.api.service;

import org.dousnl.api.domain.TPermission;

public interface TPermissionService {

	int insert(TPermission record);
	
	TPermission selectByPrimaryKey(int id, int roleId);
	
	TPermission selectByRoleKey(int roleId);
}
