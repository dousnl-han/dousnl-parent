package com.dousnl.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.codingapi.tx.annotation.TxTransaction;
import com.dousnl.domain.TUser;
import com.dousnl.mapper.TUserMapper;
import com.dousnl.service.UserServiceDubbo;
import org.springframework.transaction.annotation.Propagation;

@Service
public class UserServiceDubboImpl implements UserServiceDubbo {

	@Autowired
	private TUserMapper userMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	@TxTransaction
	public int saveUser(TUser user) {
		int insert = userMapper.insertSelective(user);
		return insert;
	}
	@Override
	public int updateUser(TUser user) {
		return 0;
	}
	@Override
	public List<TUser> listAllUser() {
		return userMapper.listAllUser();
	}
	
	
}
