package com.atguigu.springmvc.crud.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;


//用于演示自定义类型转换器
@Controller
public class ConversionHandler {

	@Autowired
	private EmployeeDao employeeDao ;
	
	@RequestMapping(value="/empAdd",method=RequestMethod.POST)
	//框架获取请求参数是一个字符串，要经过自定义类型转换器，将字符串转换为封装好的Employee,再传递给入参
	public String doAdd(@RequestParam("employee") Employee employee){
		
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
}
