package com.dousnl.shiro.mapper;

import com.dousnl.shiro.domain.Role;
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);
    
    int insertSelective(Role record,int record1);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}