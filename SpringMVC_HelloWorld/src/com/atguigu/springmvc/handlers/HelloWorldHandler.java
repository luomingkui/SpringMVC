package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//类似Struts2中的Action类；用于处理客户端请求。单例的。性能有所提高。
@Controller
@RequestMapping("/springmvc")
public class HelloWorldHandler {
	
	@RequestMapping(value="/helloworld",method=RequestMethod.GET)
	public String helloworld(){
		System.out.println(this);
		System.out.println("hello,world...");
		return "success"; 
	}
	
}
