package com.dousnl.framework.security.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import com.dousnl.framework.security.domain.Permission;
import com.dousnl.framework.security.domain.TXqb;
import com.dousnl.framework.security.domain.User;
import com.dousnl.framework.security.mapper.PermissionMapper;
import com.dousnl.framework.security.mapper.TXqbMapper;
import com.dousnl.framework.security.mapper.UserMapper;
import com.dousnl.framework.security.service.UserService;

@Service(value = "userService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private TXqbMapper tXqbMapper;
	
	@Override
	public Set<String> selectRolesByUser(User user) {
		return userMapper.selectRolesByUser(user);
	}
	/**
	 * 获取权限集合
	 * @param permission
	 * @return
	 */
	@Override
	public Set<String> selectPermissionsByUser(User user) {
		Set<String> set=new HashSet<String>();
		Permission permission=permissionMapper.selectByRoleId(user.getRoleId());
		String [] permiss=permission.getPermissionName().split(",");
		for(String s:permiss){
			set.add(s);
		}
		return set;
	}
	/**
	 * 根据账号user查询当前用户
	 * @param user
	 * @return
	 */
	@Override
	public User selectByUser(User user) {
		System.out.println("------------------UserServiceImpl---------------");
		System.out.println("User:"+JSONObject.toJSONString(user));
		return userMapper.selectByUser(user);
	}
	@Override
	public int saveUser(User user) {
		return userMapper.insert(user);
	}
	/**
	 * spring-security
	 * security-根据用户名查询用户方法
	 */
	/*@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=new User();
		user.setUsername(username);
		User user2 = userMapper.selectByUser(user);
		if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
		System.out.println("s:"+username);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
		return user2;
	}*/
	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean testTranstion() {
		try {
			User user=new User();
			Permission record=new Permission();
			record.setRoleId(1);
			record.setId(1);
			record.setPermissionName("事务测试");
			//int primaryKey = permissionMapper.updateByPrimaryKey(record);
			//int updateUser = userMapper.updateByPrimaryKeySelective(user);
			user.setId(6);
			user.setUsername("tran");
			user.setPassword("trans");
			int saveUser = userMapper.insert(user);
			int updateByMaxId = userMapper.updateByMaxId(user);
	       return true;
		} catch (Exception e) {
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RuntimeException("保存失败....");
		}
	}
	@Override
	public boolean testTranstionXqb() {
		try {
			TXqb xqb=new TXqb();
			xqb.setId(1);
			xqb.setName("事务测试");
			int primaryKey = tXqbMapper.updateByPrimaryKey(xqb);
			//int updateUser = userMapper.updateByPrimaryKeySelective(user);
			xqb.setId(2);
			int saveUser = tXqbMapper.insertSelective(xqb);
	       return true;
		} catch (Exception e) {
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RuntimeException("保存失败....");
		}
	}
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}
}
