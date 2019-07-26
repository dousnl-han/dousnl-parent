package com.dousnl;

import com.dousnl.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/25 17:56
 */
@SpringBootApplication
@RestController
public class SpringAuthoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthoServerApplication.class, args);
    }
    @RequestMapping("/say")
    public String sayHi(){
        return "sak";
    }
    @RequestMapping("/api/userinfo")
    public User userHi(){
        return new User("bobo","1219@12dswd");
    }
}
