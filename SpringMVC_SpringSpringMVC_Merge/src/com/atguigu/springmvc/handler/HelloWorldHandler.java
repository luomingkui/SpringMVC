package com.atguigu.springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@Scope("prototype")   SpringMC框架中的处理器单例的。比Strut2框架性能高。
public class HelloWorldHandler {
	
	@Autowired
	private XxxService xxxService ;

	public HelloWorldHandler(){
		System.out.println("HelloWorldHandler Constructor....");
	}
	
	@RequestMapping("/helloworld")
	public String helloworld(){
		
		System.out.println("xxxService = "+xxxService);
		
		System.out.println("SpringMVC , Hello, World....");
		
		xxxService.save();
		
		return "success";
	}
	
}
