package com.dousnl.mapper;

import com.dousnl.domain.TXqb;

public interface TXqbMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(TXqb record);

	int insertSelective(TXqb record);

	TXqb selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TXqb record);

	int updateByPrimaryKey(TXqb record);

}