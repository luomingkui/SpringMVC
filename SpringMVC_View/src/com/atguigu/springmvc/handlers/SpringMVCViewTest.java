package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCViewTest {
	
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView...");
		return "success";
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver...");
		return "success";
	}
	
	@RequestMapping("/testMyView")
	public String testMyView(){
		System.out.println("testMyView...");
		return "helloView"; //与视图Bean 对象的id一致，应该采用BeanNameViewResolver进行视图解析
	}

}
