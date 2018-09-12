package org.dousnl.mapper;

import org.apache.ibatis.annotations.Param;
import org.dousnl.api.domain.TPermission;

public interface TPermissionMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(@Param("id") Integer id, @Param("roleId") Integer roleId);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);
}