package org.dousnl.shiro.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义信用校验器(密码校验)
 * @author hanliang
 *
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{
 
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
    {
		UsernamePasswordToken utoken=(UsernamePasswordToken) token;
		//获取用户密码(可以采用加盐(salt)方式校验)
		String inPassword=new String(utoken.getPassword());
		//从数据库中获取的密码
		String dbPassword=(String) info.getCredentials();
        return equals(inPassword, dbPassword);
    }
}
