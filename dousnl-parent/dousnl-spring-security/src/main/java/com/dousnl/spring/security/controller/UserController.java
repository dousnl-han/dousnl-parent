package com.dousnl.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dousnl.spring.security.common.slfj;

@RestController
@RequestMapping("/user")
@slfj(value="user控制器")
public class UserController {

	@GetMapping
    public String getUsers() {       
        return "Hello Spring Security";
    }
}
