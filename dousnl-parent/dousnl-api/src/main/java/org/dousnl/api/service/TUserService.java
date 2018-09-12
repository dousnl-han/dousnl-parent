package org.dousnl.api.service;

import org.dousnl.api.domain.TUser;

public interface TUserService {

	TUser selectByPrimaryKey(int id);
}
