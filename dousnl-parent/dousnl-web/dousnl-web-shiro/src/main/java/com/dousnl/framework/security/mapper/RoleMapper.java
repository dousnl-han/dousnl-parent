package com.dousnl.framework.security.mapper;

import org.apache.ibatis.annotations.Param;

import com.dousnl.framework.security.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);
    
    int insertSelective(Role record,int record1);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	Role getRole(@Param("roleId")Integer roleId);
}