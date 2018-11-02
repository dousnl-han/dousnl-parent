package com.dousnl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.codingapi.tx.annotation.TxTransaction;
import com.dousnl.domain.TUser;
import com.dousnl.domain.TXqb;
import com.dousnl.mapper.TXqbMapper;


@Service
public class XqbServiceImpl implements XqbService{
	
	@Autowired
	private UserServiceDubboClient userServiceDubbo;
	@Autowired
	private TXqbMapper tXqbMapper;

	@Override
	@TxTransaction(isStart = true)
	@Transactional
	public boolean testFbs() {
		/*TUser u=new TUser();
		u.setId(8);
		u.setUsername("tran1");
		u.setPassword("trans1");*/
		userServiceDubbo.saveUser();
		TXqb xqb=new TXqb();
		xqb.setId(2);
		xqb.setName("事务测试");
		int primaryKey = tXqbMapper.insertSelective(xqb);
        return true;
	}

	@Override
	@Transactional
	public boolean testBC() {
		TXqb xqb=new TXqb();
		xqb.setId(2);
		xqb.setName("事务测试");
		int primaryKey = tXqbMapper.insertSelective(xqb);
		return primaryKey>0;
	}

	

}
