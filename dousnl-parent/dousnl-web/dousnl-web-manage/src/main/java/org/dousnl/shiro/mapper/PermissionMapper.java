package org.dousnl.shiro.mapper;

import org.apache.ibatis.annotations.Param;
import org.dousnl.shiro.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    Permission selectByRoleId(@Param("roleId") Integer roleId);
}