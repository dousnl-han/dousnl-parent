package com.dousnl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Reference;
import com.codingapi.tx.annotation.TxTransaction;
import com.dousnl.api.domain.TUser;
import com.dousnl.domain.TXqb;
import com.dousnl.mapper.TXqbMapper;
import com.dousnl.service.UserServiceDubbo;
import com.dousnl.service.XqbService;

@Service
public class XqbServiceImpl implements XqbService{

	@Autowired
	private TXqbMapper tXqbMapper;
	
	@Autowired
	private UserServiceDubbo userServiceDubbo;
	
	/*@Override
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
	}*/
	
	/**
	 * test fbs transactional 默认的shiro userService不支持事务,
	 * 此处用tXqbMapper测试(分布式事务)
	 * 2018年10月11日 下午2:07:24
	 */
	@Override
	@TxTransaction(isStart = true)
	@Transactional
	public boolean testTranstionXqb() {
		//try {
			TUser u=new TUser();
			u.setId(8);
			u.setUsername("tran1");
			u.setPassword("trans1");
			int saveUser = userServiceDubbo.saveUser(u);
			TXqb xqb=new TXqb();
			xqb.setId(1);
			xqb.setName("事务测试");
			int primaryKey = tXqbMapper.insertSelective(xqb);
			//int updateUser = userMapper.updateByPrimaryKeySelective(user);
			//xqb.setId(1);
			//int saveUser = tXqbMapper.insertSelective(xqb);
			//int i=1/0;
	       return true;
		/*} catch (Exception e) {
			throw new RuntimeException("保存失败....");
		}*/
	}

}
