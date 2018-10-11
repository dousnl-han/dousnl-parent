package com.dousnl.service;

import javax.ws.rs.Path;

import com.dousnl.api.domain.TUser;
import com.dousnl.api.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.dousnl.mapper.TUserMapper;

/*@Service(protocol={"dubbo"})
@Path("tUserService")*/
public class TUserServiceImpl implements TUserService{

	@Autowired
	private TUserMapper tUserMapper;
	
	@Override
	public TUser selectByPrimaryKey(int id) {
		return tUserMapper.selectByPrimaryKey(id);
	}

}
