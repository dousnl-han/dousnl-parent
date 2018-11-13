package com.dousnl.service;

import javax.ws.rs.Path;
import com.dousnl.domain.TRole;
import com.dousnl.service.TRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.dousnl.mapper.TRoleMapper;

/*@Service(protocol={"dubbo"})
@Path("tRoleService")*/
public class TRoleServiceImpl implements TRoleService{

	@Autowired
	private TRoleMapper tRoleMapper;
	
	@Override
	public TRole selectByPrimaryKey(int id) {
		return tRoleMapper.selectByPrimaryKey(id);
	}

}
