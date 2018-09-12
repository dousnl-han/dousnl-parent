package org.dousnl.shiro.mapper;

import org.dousnl.shiro.domain.TXqb;

public interface TXqbMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(TXqb record);

	int insertSelective(TXqb record);

	TXqb selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TXqb record);

	int updateByPrimaryKey(TXqb record);

}