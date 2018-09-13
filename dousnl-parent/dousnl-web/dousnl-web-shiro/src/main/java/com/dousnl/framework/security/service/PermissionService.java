package com.dousnl.framework.security.service;

import java.util.List;

public interface PermissionService {

	List<String> getPermissions(Integer roleId);

}
