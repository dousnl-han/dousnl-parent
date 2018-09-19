package com.dousnl.framework.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dousnl.framework.security.domain.Role;
import com.dousnl.framework.security.mapper.RoleMapper;
import com.dousnl.framework.security.service.RoleService;

@Service(value="userAuthService")
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public Role getRole(Integer roleId) {
		return roleMapper.getRole(roleId);
	}

}
