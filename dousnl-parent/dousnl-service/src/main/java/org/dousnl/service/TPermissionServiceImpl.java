package org.dousnl.service;

import javax.ws.rs.Path;

import org.dousnl.api.domain.TPermission;
import org.dousnl.api.service.TPermissionService;
import org.dousnl.mapper.TPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol={"dubbo"})
@Path("tPermissionService")
public class TPermissionServiceImpl implements TPermissionService{

	@Autowired
	private TPermissionMapper tPermissionMapper;
	@Override
	public int insert(TPermission record) {
		return tPermissionMapper.insert(record);
	}

	@Override
	public TPermission selectByPrimaryKey(int id, int roleId) {
		return tPermissionMapper.selectByPrimaryKey(id, roleId);
	}

	@Override
	public TPermission selectByRoleKey(int roleId) {
		return tPermissionMapper.selectByPrimaryKey(1, roleId);
	}

}
