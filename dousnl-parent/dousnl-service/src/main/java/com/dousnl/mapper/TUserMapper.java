package com.dousnl.mapper;

import java.util.List;

import com.dousnl.api.domain.TUser;

public interface TUserMapper {
	
	int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    List<TUser> listAllUser();
}