package com.dousnl.mapper;

import org.apache.ibatis.annotations.Param;

import com.dousnl.domain.TPermission;

public interface TPermissionMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);
}