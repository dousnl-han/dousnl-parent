package com.dousnl.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类功能描述
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/23 16:51
 */
@Controller
public class SecurityController {

    @GetMapping(value = {"/home","/"})
    public String home(){
        return "home";
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
