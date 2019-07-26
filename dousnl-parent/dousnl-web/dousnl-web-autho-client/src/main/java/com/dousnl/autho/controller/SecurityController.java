package com.dousnl.autho.controller;

import com.dousnl.autho.domain.User;
import com.dousnl.autho.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类功能描述
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/23 16:51
 */
@Controller
public class SecurityController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = {"/home","/"})
    @ResponseBody
    public String home(){
        return userMapper.selectByUser(new User("te001")).getRoleId().toString();
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/admin")
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "admin";
    }
}
