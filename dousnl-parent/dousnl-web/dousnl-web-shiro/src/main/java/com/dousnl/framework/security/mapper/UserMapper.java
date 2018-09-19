package com.dousnl.framework.security.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.dousnl.framework.security.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUser(User user);
    
	Set<String> selectRolesByUser(User user);

	Set<String> selectPermissionsByUser(User user);
    
    int updateByMaxId(User user);

	User findByUsername(@Param("username")String username);
}