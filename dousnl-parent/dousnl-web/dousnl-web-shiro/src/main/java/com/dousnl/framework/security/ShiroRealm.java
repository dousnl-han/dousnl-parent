package com.dousnl.framework.security;


import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.dousnl.framework.security.domain.Role;
import com.dousnl.framework.security.domain.User;
import com.dousnl.framework.security.service.PermissionService;
import com.dousnl.framework.security.service.RoleService;
import com.dousnl.framework.security.service.UserService;

public class ShiroRealm extends CasRealm{

    private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	/**
     * 授权访问控制，用于对用户进行的操作进行人证授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
        User user = userService.findByUsername(username);

        if (user != null) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

            // 设置用户的角色
            //String roleId = userService.getRoleIdFromUserId(user.getId());
            Role roleEntity = roleService.getRole(user.getRoleId());
            if (null != roleEntity)
                authorizationInfo.addRole(roleEntity.getRoleName());

            // 设置用户对应的角色的权限集合
            List<String> permissons;
            try {
                permissons = permissionService.getPermissions(user.getRoleId());
                for (String permission : permissons) {
                    authorizationInfo.addStringPermission(permission);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return authorizationInfo;
        }
        return null;
	}
	
	
	/**
     * 验证用户身份
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return super.doGetAuthenticationInfo(token);
	}
	
	@Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCachedKickoutInfo() {

    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
        clearAllCachedKickoutInfo();
    }
}
