package com.atguigu.springmvc.crud.handlers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		
		//map.put("command", new Employee());
		map.put("employee", new Employee());
		
		return "add";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String doAdd(@Valid Employee employee,BindingResult bindingResult,Map map){
		
		if(bindingResult.getErrorCount() > 0 ){
			System.out.println("类型转换处错误了");
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				System.out.println(fieldError.getField() + " - " + fieldError.getDefaultMessage());
			}
			//如果类型转换失败后，希望跳转到添加页面，显示下拉列选
			map.put("deptList", departmentDao.getDepartments());
			return "add";
		}

		
		System.out.println(employee);
		
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
		
		//map.put("command", employeeDao.get(id));
		map.put("employee", employeeDao.get(id));
		
		return "update";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	//public String delete(Employee employee){
	public String delete(@ModelAttribute(value="emp")  Employee employee){
		
		employeeDao.save(employee); //更新和保存共用一个方法
		
		return "redirect:/emps";
	}
	
	//在每一个处理器方法前都要执行
	@ModelAttribute 
	public void getEmployee(@RequestParam(value="id",required=false) Integer id, Map<String,Object> map){ //这个方法提供模型对象，不是处理请求的方法，没有@RequestMapping
		if(id!=null){
			Employee employee = employeeDao.get(id);
			
			//map.put("employee", employee); //key为处理请求的参数类型的名称首字母小写
			map.put("emp", employee); 
		}
	}
	
	/**
	 * 由 @InitBinder 标识的方法，可以对 WebDataBinder 对象进行初始化。
		WebDataBinder 是 DataBinder 的子类，用于完成由表单字段到 JavaBean 属性的绑定
		@InitBinder方法不能有返回值，它必须声明为void。
		@InitBinder方法的参数通常是 WebDataBinder
	 * @param dataBinder
	 */
/*	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		//在给处理器方法入参POJO对象属性绑定的参数时，不希望特定参数被绑定时，可以通过这个方法来处理参数绑定问题。
		dataBinder.setDisallowedFields("lastName");
	}*/
	
}
