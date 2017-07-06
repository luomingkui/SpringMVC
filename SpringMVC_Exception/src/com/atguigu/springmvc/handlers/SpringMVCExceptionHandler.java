package com.atguigu.springmvc.handlers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.exception.UsernameNotMatchPasswordException;

@Controller
public class SpringMVCExceptionHandler {

	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(
			@RequestParam(value = "i", required = false, defaultValue = "0") int i) {

		int result = 10 / i;

		System.out.println("result=" + result);

		return "success";
	}

	//这种方法无法获取错误消息，不建议使用
	/*@ExceptionHandler(value = { java.lang.ArithmeticException.class })
	public String handleException(Exception ex, Map<String, Object> map) {
		System.out.println("出现异常啦" + ex);
		// 希望将Exception对象传递给页面，不能使用Map
		map.put("exception", ex);
		return "error";
	}*/

	//這種方法在頁面可以獲取錯誤，但是為了更為通用，我們提取為公共類，該錯誤消息對所有的方法都使用
	/* @ExceptionHandler(value={java.lang.ArithmeticException.class})
	 public ModelAndView handleException(Exception ex){
		 System.out.println("出现异常啦"+ex);
		 ModelAndView mv = new ModelAndView("error"); 
		 mv.addObject("exception",ex) ; 
		 return mv; 
	 }*/
	 

	/*
	 @ExceptionHandler(value={java.lang.RuntimeException.class})
	 public ModelAndView handleException2(Exception ex){
		 System.out.println("RuntimeException-出现异常啦:"+ex);
		 ModelAndView mv = new
		 ModelAndView("error"); 
		 mv.addObject("exception", ex); 
		 return mv;
	 }*/
	 

	//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "测试方法上设置响应状态码")
	@RequestMapping(value = "/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i) {
		if (i == 10) {
			throw new UsernameNotMatchPasswordException();
		}
		System.out.println("testResponseStatusExceptionResolver...");
		return "success";
	}

}
