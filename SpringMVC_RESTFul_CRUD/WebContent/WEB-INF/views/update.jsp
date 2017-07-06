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
	
		<form:hidden path="id"/>
	
		<!-- 由于模型对象中没有 "_method"这个属性，所以不能进行表单回显，所以不能使用form:hidden标签作为隐含域，而是采用html标签 -->
		<input type="hidden" name="_method" value="PUT">
	
	
		<!-- lastName 不需要更新，保证这个属性值不丢失 -->
		<%-- LastName : <form:input path="lastName"/> <br><br> --%>
		
		
		Email : <form:input path="email"/><br><br>
		
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
		
		<input type="submit" value="修改">  <br><br>
	</form:form>

</body>
</html>