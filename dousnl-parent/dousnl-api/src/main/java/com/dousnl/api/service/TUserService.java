package com.dousnl.api.service;

import com.dousnl.api.domain.TUser;

public interface TUserService {

	TUser selectByPrimaryKey(int id);
}
