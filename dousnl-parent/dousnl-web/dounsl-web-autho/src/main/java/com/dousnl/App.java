package com.dousnl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @ResponseBody
    @RequestMapping("/say")
    public String say(){
        return "assds";
    }
}
