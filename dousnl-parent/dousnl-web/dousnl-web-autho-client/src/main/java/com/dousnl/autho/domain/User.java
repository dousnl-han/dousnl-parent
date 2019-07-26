package com.dousnl.autho.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Fairyland
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer id;

    private String workNo;
    
	private String username;

    private String password;

    private String address;

    private Integer roleId;
    
    private List<Role> roles;

    private static final long serialVersionUID = 1L;

    public User(String username){
        this.username=username;
    }
    public User(String username,String address){
        this.username=username;
        this.address=address;
    }
	/**
	 * spring-security
	 * 自定义增加角色方法
	 */
	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = this.getRoles();
        for (Role role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}*/
    
}
