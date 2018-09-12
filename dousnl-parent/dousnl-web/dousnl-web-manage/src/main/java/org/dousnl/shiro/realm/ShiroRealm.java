package org.dousnl.shiro.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.dousnl.shiro.domain.User;
import org.dousnl.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("shiroRealm")
public class ShiroRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	/**
	 * 授权
	 * @description 为当前登陆成功的用户授予角色和权限
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param arg0
	 * @parameter @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
		User user=new User();
		user.setUsername(username);
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.selectRolesByUser(user));
		System.out.println("==================授权AuthorizationInfo ===============");
		System.out.println("UserInfo:"+authorizationInfo.getRoles());
		System.out.println("==================授权AuthorizationInfo ===============");
		User PermissionsUser=userService.selectByUser(user);
		authorizationInfo.setStringPermissions(userService.selectPermissionsByUser(PermissionsUser));
		return authorizationInfo;
	}
	/**
	 * 认证，登陆
	 * @description 验证当前登陆用户的身份信息
	 * @author hanliang
	 * @version 1.0
	 * @parameter @param arg0
	 * @parameter @return
	 * @parameter @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
        try {
        	Session session = null;
        	UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
    		User user=new User();
    		char[] ps=usernamePasswordToken.getPassword();
    		String password="";
    		for (char c : ps) {
    			password+=c;
			}
    		user.setUsername(usernamePasswordToken.getUsername());
    		user.setPassword(password);
            User principalUser=userService.selectByUser(user);
            /*if (null==principalUser) {
            	session.setAttribute("loginInfo", "验证失败,请重新输入！");
			}*/
            System.out.println("==================认证，登陆AuthenticationInfo===============");
    		System.out.println("principalUser:"+principalUser.getUsername()+"\t"+principalUser.getPassword());
    		System.out.println("==================认证，登陆AuthenticationInfo===============");
            if(principalUser!=null){
            	AuthenticationInfo authInfo=new SimpleAuthenticationInfo(principalUser.getUsername(), principalUser.getPassword(), "xx");
                return authInfo;
            }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
