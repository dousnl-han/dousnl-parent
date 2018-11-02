package com.dousnl.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dousnl.shiro.domain.Permission;
import com.dousnl.shiro.mapper.PermissionMapper;
import com.dousnl.shiro.service.PermissionService;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id, Integer roleId) {
		return permissionMapper.deleteByPrimaryKey(id, roleId);
	}

	@Override
	public int insert(Permission record) {
		return permissionMapper.insert(record);
	}

	@Override
	public int insertSelective(Permission record) throws Exception {
		int i=0;
		try {
			i=permissionMapper.insertSelective(record);
		} catch (Exception e) {
			//System.out.println(">>>>>>>新增--permission异常");
			throw new Exception(">>>>>>>新增--permission异常");
		}
		return i;
	}

	@Override
	public Permission selectByPrimaryKey(Integer id, Integer roleId) {
		return permissionMapper.selectByPrimaryKey(id, roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Permission record) {
		return permissionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Permission record) {
		return permissionMapper.updateByPrimaryKey(record);
	}

	@Override
	public Permission selectByRoleId(Integer roleId) {
		return permissionMapper.selectByRoleId(roleId);
	}

}
