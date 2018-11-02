/*package com.dousnl.service.impl;

import java.util.List;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Service;
import com.codingapi.tx.annotation.TxTransaction;
import com.dousnl.api.domain.TUser;
import com.dousnl.api.service.UserServiceDubbo;
import com.dousnl.mapper.TUserMapper;
import org.springframework.transaction.annotation.Propagation;

@Service(protocol={"dubbo"})
@Path("userServiceDubbo")
//@TxTransaction
//@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserServiceDubboImpl implements UserServiceDubbo {

	@Autowired
	private TUserMapper userMapper;
	
	@Override
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
*/