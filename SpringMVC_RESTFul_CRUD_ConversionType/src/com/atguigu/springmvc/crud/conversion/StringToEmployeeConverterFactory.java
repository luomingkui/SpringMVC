package com.atguigu.springmvc.crud.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;

//实现字符串到Employee对象的类型转换
@Component
public class StringToEmployeeConverterFactory<T> implements
		Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		if (source != null) {
			String[] strs = source.split("-");
			if (strs != null && strs.length == 4) {
				String lastName = strs[0];
				String email = strs[1];
				Integer gender = Integer.parseInt(strs[2]);
				Integer deptId = Integer.parseInt(strs[3]);
				Department dept = new Department();
				dept.setId(deptId);
				Employee employee = new Employee(null, lastName, email, gender,dept);
				System.out.println(source + "--converter--" + employee);
				return employee;
			}
		}

		return null;
	}

}
