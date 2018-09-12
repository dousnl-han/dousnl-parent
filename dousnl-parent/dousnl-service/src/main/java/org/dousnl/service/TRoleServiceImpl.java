package org.dousnl.service;

import javax.ws.rs.Path;
import org.dousnl.api.domain.TRole;
import org.dousnl.api.service.TRoleService;
import org.dousnl.mapper.TRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol={"dubbo"})
@Path("tRoleService")
public class TRoleServiceImpl implements TRoleService{

	@Autowired
	private TRoleMapper tRoleMapper;
	
	@Override
	public TRole selectByPrimaryKey(int id) {
		return tRoleMapper.selectByPrimaryKey(id);
	}

}
