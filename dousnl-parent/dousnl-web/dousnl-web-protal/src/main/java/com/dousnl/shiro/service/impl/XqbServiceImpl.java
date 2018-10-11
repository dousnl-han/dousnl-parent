package com.dousnl.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Reference;
import com.codingapi.tx.annotation.TxTransaction;
import com.dousnl.api.domain.TUser;
import com.dousnl.api.service.UserServiceDubbo;
import com.dousnl.shiro.domain.TXqb;
import com.dousnl.shiro.mapper.TXqbMapper;
import com.dousnl.shiro.service.XqbService;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class XqbServiceImpl implements XqbService{

	@Autowired
	private TXqbMapper tXqbMapper;
	@Reference(group="trade")
	private UserServiceDubbo userServiceDubbo;
	
	/**
	 * test fbs transactional 默认的shiro userService不支持事务,
	 * 此处用tXqbMapper测试(分布式事务)
	 * 2018年10月11日 下午2:07:24
	 */
	@Override
	@TxTransaction(isStart = true)
	public boolean testTranstionXqb() {
		try {
			TXqb xqb=new TXqb();
			xqb.setId(1);
			xqb.setName("事务测试");
			int primaryKey = tXqbMapper.updateByPrimaryKey(xqb);
			//int updateUser = userMapper.updateByPrimaryKeySelective(user);
			//xqb.setId(1);
			//int saveUser = tXqbMapper.insertSelective(xqb);
			TUser u=new TUser();
			u.setId(7);
			u.setUsername("tran1");
			u.setPassword("trans1");
			//int saveUser = userServiceDubbo.saveUser(u);
	       return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("保存失败....");
		}
	}

}
