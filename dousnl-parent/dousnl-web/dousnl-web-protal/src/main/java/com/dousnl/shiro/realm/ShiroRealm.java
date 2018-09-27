package com.dousnl.shiro.realm;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dousnl.shiro.domain.User;
import com.dousnl.shiro.service.UserService;

@Component("shiroRealm")
public class ShiroRealm extends AuthorizingRealm{

	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	
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
    		String password=new String(usernamePasswordToken.getPassword());
    		
    		User user=new User();
    		user.setUsername(usernamePasswordToken.getUsername());
    		user.setPassword(password);
            User principalUser=userService.selectByUser(user);
            /*if (null==principalUser) {
            	session.setAttribute("loginInfo", "验证失败,请重新输入！");
			}*/
            System.out.println("==================认证，登陆AuthenticationInfo===============");
            if(principalUser!=null){
            	System.out.println("-------------认证，通过-------------");
            	System.out.println("principalUser:"+principalUser.getUsername()+"\t"+principalUser.getPassword());
            	AuthenticationInfo authInfo=new SimpleAuthenticationInfo(principalUser.getUsername(), principalUser.getPassword(), "xx");
            	 //this.setSession("userVo", token.getPrincipal());//从数据库查询出的user对象
            	return authInfo;
            }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *    比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            logger.info("key=[{}],value=[{}]插入session[{}],host=[{}]" ,key,value,session.getId(),session.getHost());
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
}
