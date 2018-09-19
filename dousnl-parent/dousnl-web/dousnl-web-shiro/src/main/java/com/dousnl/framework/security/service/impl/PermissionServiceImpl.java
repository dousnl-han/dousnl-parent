package com.dousnl.framework.security.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dousnl.framework.security.mapper.PermissionMapper;
import com.dousnl.framework.security.service.PermissionService;


@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<String> getPermissions(Integer roleId) {
		return permissionMapper.getPermissions(roleId);
	}

}
