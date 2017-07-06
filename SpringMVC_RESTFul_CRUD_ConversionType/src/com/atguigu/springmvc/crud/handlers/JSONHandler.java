package com.atguigu.springmvc.crud.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class JSONHandler {

	@Autowired
	private EmployeeDao employeeDao ;
	
	@ResponseBody //如果添加了jackson相关jar包，那么，通过这个注解将返回对象信息格式化为 json 字符串。
	@RequestMapping("/testJSON")
	public Collection<Employee> testJSON(){
		
		Collection<Employee> emps = employeeDao.getAll();

		return emps ;
	}
	
	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "Hello,"+new Date();
	}
	
	@RequestMapping("/responseEntity")
	public ResponseEntity<byte[]> responseEntity(HttpSession session) throws IOException{
		//getResourceAsStream()可以从项目根路径下获取资源转换为输入流
		/*ServletContext application = session.getServletContext() ;
		InputStream is = application.getResourceAsStream("/abc.txt");*/
		
		//从classpath路径加载资源转换为输入流
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("abc.txt");
		
		byte[] b = new byte[is.available()] ;
		is.read(b);
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");  //以附件，另存为窗口方式保存文件。
		
		HttpStatus statusCode = HttpStatus.OK ; 
		
		ResponseEntity<byte[]> httpEntity = new ResponseEntity<byte[]>(b,headers,statusCode);
		
		return httpEntity ;
	}
	
	
}
