<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 利用SpringMVC框架提供的标签库完成表单页面开发
		好处：自动回显
		
		表单回显时需要获取一个模型对象名称为: "commond"对应的实体对象的属性值；如果没有这个实体对象就会抱错：
			java.lang.IllegalStateException: Neither BindingResult nor plain target object for bean name 'command' available as request attribute
	 
	 	只需要在控制器方法的map中绑定一个  map.put("commond",obj); //obj中只要提供表单上所有path属性对应属性名称就可以
	 	
	 	如果希望map中的key不为command;可以在表单上使用modelAttribute来指定map中的key,从key所对应的对象中查找与path名称一致的属性
	 -->
	
	<form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
		 <%-- <form:errors path="*"></form:errors><br><br> --%>
		
		LastName : <form:input path="lastName"/><form:errors path="lastName"></form:errors> <br><br>
		Email : <form:input path="email"/> <form:errors path="email"></form:errors><br><br>
		
		<%
			Map<String,String> genders = new HashMap<String,String>(); 
			genders.put("0", "female");
			genders.put("1", "male");
			request.setAttribute("genders", genders);
		%>
		
		Gender : <form:radiobuttons path="gender" items="${requestScope.genders }"/> <br><br>
		
		<!-- 
		itemLabel : 用于下拉中显示
		itemValue : 用于提交选择的选项值
		 -->
		deptName : <form:select path="department.id" 
				items="${requestScope.deptList }" 
				itemLabel="departmentName" 
				itemValue="id"></form:select>  <br><br>
				
		birthDay : <form:input path="birthDay"/><form:errors path="birthDay"></form:errors><br><br>
		
		salary : <form:input path="salary"/><br><br>
		
		<input type="submit" value="添加">  <br><br>
	</form:form>
	
	<hr>
	
	
	<form action="${pageContext.request.contextPath }/empAdd" method="POST">
         <!-- 解决问题：
                 1.数据类型转换
                 2.数据格式
                 3.数据校验                 
                 自定义类型转换器：
	                         将字符串转换为Employee对象,完成添加功能               
			-->
			<!-- 字符串格式：lastName-email-gender-department.id
			    例如：GG-gg@atguigu.com-0-105        
			 -->
			Employee : <input type="text" name="employee"/>                                
	        <input type="submit" value="Submit"><br><br>
	</form>
	
	
	

</body>
</html>