package com.dousnl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dousnl.domain.TXqb;
import com.dousnl.mapper.TXqbMapper;
import com.dousnl.service.XqbService;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class XqbServiceImpl implements XqbService{

	@Autowired
	private TXqbMapper tXqbMapper;
	
	@Override
	public boolean testTranstionXqb() {
		try {
			TXqb xqb=new TXqb();
			xqb.setId(1);
			xqb.setName("事务测试");
			int primaryKey = tXqbMapper.updateByPrimaryKey(xqb);
			//int updateUser = userMapper.updateByPrimaryKeySelective(user);
			xqb.setId(1);
			int saveUser = tXqbMapper.insertSelective(xqb);
	       return true;
		} catch (Exception e) {
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RuntimeException("保存失败....");
		}
	}

}
