package org.dousnl.shiro.mapper;

import java.util.Set;

import org.dousnl.shiro.domain.User;
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
    
    
}