package com.dousnl.controller;

import com.alibaba.fastjson.JSON;
import com.dousnl.domain.WeChatUser;
import com.dousnl.domain.WechatAuthProperties;
import com.dousnl.service.WeChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/24 16:02
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    private int count = 1000;

    @GetMapping("/login/{code}")
    public String weChatLogin(@PathVariable("code") String code) {
        //log.info("code:"+code);
        String s = weChatService.wechatLogin(code);
        log.info(s);
        return s;
    }

    @PostMapping("/login/user")
    public String weChatLoginUser(@RequestBody WeChatUser user) {
        String s = JSON.toJSONString(user);
        log.info(">>>>>>>>>微信服务器获取用户信息:{}", s);
        return s;
    }

    @GetMapping("/{code}")
    public String weChat(@PathVariable("code") String code) {
        System.out.println("code:" + code);
        return code;
    }

    @GetMapping("/test/bf")
    public String weChatTestBf() throws InterruptedException {
        log.info(">>>>>>>当前线程name:{}, 线程id:{} ", Thread.currentThread().getName(), Thread.currentThread().getId());
        count--;
        log.info(">>>>>>count:{}", count);
        Thread.sleep(1000);
        return Thread.currentThread().getId() + "";
    }
}
