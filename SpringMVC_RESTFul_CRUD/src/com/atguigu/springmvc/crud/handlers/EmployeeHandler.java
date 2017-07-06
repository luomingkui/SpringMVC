package com.atguigu.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;

//完成RESTFul风格——CRUD操作
@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao ;
	
	@Autowired
	private DepartmentDao departmentDao ;
	
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String queryAllEmps(Map<String,Object> map){
		map.put("empList", employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String toAdd(Map<String,Object> map){//BindingAwareModelMap
		map.put("deptList", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "add";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String doAdd(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String toUpdate(@PathVariable("id") Integer id , Map<String,Object> map){//BindingAwareModelMap
		map.put("deptList", departmentDao.getDepartments());		
		map.put("employee", employeeDao.get(id));
		return "update";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String delete(@ModelAttribute(value="emp")  Employee employee){
		employeeDao.save(employee); //更新和保存共用一个方法
		return "redirect:/emps";
	}
	
	//在每一个处理器方法前都要执行
	@ModelAttribute 
	public void getEmployee(@RequestParam(value="id",required=false) Integer id, Map<String,Object> map){ //这个方法提供模型对象，不是处理请求的方法，没有@RequestMapping
		if(id!=null){
			Employee employee = employeeDao.get(id);
			map.put("emp", employee); 
		}
	}
	
}
