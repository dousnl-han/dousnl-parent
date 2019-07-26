package com.dousnl.autho.service;

import com.dousnl.autho.domain.User;
import com.dousnl.autho.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/26 16:43
 */
@Service("clientUserDetailsService")
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = Optional.ofNullable(userMapper.selectByUser(new User(username)));
        if (!user.isPresent()){
            throw new UsernameNotFoundException("invalid username or password...!");
        }
        return new ClientUserDetails(user.get());
    }


}
