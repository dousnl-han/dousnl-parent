package com.dousnl.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/httpclient/")
public class HttpClientDemoController {

	@RequestMapping("jsondemo")
	@ResponseBody
	public List httpJsonTest(){
		List<String> list=new ArrayList<String>();
		list.add("test");
		return list;		
	}
}
