package com.dousnl.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dousnl.shiro.domain.User;
import com.dousnl.shiro.mapper.UserMapper;

public class AuthShiroRealm extends AuthorizingRealm{

	@Autowired
	private UserMapper userMapper;
	/**
	 * @description 为当前登陆成功的用户授予角色和权限
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param arg0
	 * @parameter @return
	 */
	/*@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
		User user=(User)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userMapper.selectRolesByUser(user));
		authorizationInfo.setStringPermissions(userMapper.selectPermissionsByUser(user));
		return authorizationInfo;
	}*/
	/**
	 * 身份验证
	 * @description 验证当前登陆用户的身份信息
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param arg0
	 * @parameter @return
	 * @parameter @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user=(User)token.getPrincipal();
        User principalUser=userMapper.selectByUser(user);
        if(principalUser!=null){
        	AuthenticationInfo authInfo=new SimpleAuthenticationInfo(principalUser.getUsername(), principalUser.getPassword(), "xx");
            return authInfo;
        }
		return null;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
