package com.dousnl.shiro.service;

import org.apache.ibatis.annotations.Param;

import com.dousnl.shiro.domain.Permission;

public interface PermissionService {

	int deleteByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int insert(Permission record);

    int insertSelective(Permission record) throws Exception;

    Permission selectByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);
    
    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    Permission selectByRoleId(@Param("roleId") Integer roleId);
}
