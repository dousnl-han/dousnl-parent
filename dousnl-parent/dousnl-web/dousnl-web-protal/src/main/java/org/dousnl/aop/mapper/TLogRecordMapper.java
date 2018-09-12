package org.dousnl.aop.mapper;

import org.dousnl.aop.TLogRecord;

public interface TLogRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(TLogRecord record);

    int insertSelective(TLogRecord record);

    TLogRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TLogRecord record);

    int updateByPrimaryKey(TLogRecord record);
}