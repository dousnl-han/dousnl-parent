package com.dousnl.autho;

import com.dousnl.autho.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * TODO
 *
 * @author hanliang
 * @version 1.0
 * @date 2019/7/25 17:56
 */
@SpringBootApplication
@RestController
public class SpringAuthoClientApplication implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthoClientApplication.class, args);
    }
    @RequestMapping("/say")
    public String sayHi(){
        return "sak";
    }
    @RequestMapping("/api/userinfo")
    public User userHi(){
        return new User("bobo","1219@12dswd");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.getSessionCookieConfig().setName("client-session");
    }
}
