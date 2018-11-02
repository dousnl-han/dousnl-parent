package com.dousnl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dousnl.service.HelloService;

/**
 * @author Fairyland
 * 1)如果只是使用@RestController注解Controller，
 * 则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 既能返回string或者json又能进行页面跳转怎么办。现在终于明白：点击打开链接。在这篇文章中介绍的非常详细，简单说来就是：
 * @RestController = @Controller + @ResponseBody。
 * 所以，以后定义controller的时候，可以直接使用@Controller，如果需要返回json可以直接在方法中添加@ResponseBody即可。
 * 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 */
@RestController
public class HelloControler {

	@Autowired
    HelloService helloService;
	
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.helloService(name);
    }
    @RequestMapping(value = "/index")
    public String hiIndex(@RequestParam String name){
        return "index";
    }
}
