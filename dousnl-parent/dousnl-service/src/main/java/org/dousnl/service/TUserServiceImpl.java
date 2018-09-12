package org.dousnl.service;

import javax.ws.rs.Path;

import org.dousnl.api.domain.TUser;
import org.dousnl.api.service.TUserService;
import org.dousnl.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol={"dubbo"})
@Path("tUserService")
public class TUserServiceImpl implements TUserService{

	@Autowired
	private TUserMapper tUserMapper;
	
	@Override
	public TUser selectByPrimaryKey(int id) {
		return tUserMapper.selectByPrimaryKey(id);
	}

}
