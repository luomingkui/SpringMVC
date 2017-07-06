<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
	警告: No mapping found for HTTP request with 
	URI [/SpringMVC_03_RESTFul_CRUD/scripts/jquery-1.9.1.min.js] in DispatcherServlet 
	with name 'springDispatcherServlet'
 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>	

<script type="text/javascript">
	$(function(){
		
		 $(".delete").click(function(){
			 var href = this.href ;
			//var href = $(this).attr("href") ;
			$("form").attr("action",href).submit();
			
			return false ;
		});
		
	});

</script>

</head>
<body>

	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE">
	</form>

	<!-- SPringMVC中没有用于迭代的标签，所以，迭代员工时需要使用JSTL标签库的迭代标签 -->
	<c:if test="${empty requestScope.empList }">
		没有查询都任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.empList }">
		<center>
			<table border="1" width="80%">
				
				<tr>
					<th>ID</th>
					<th>lastName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>DeptName</th>
					<th>更新</th>
					<th>删除</th>
				</tr>
				
				<c:forEach items="${requestScope.empList }" var="emp">
					<tr>
						<td>${emp.id }</td>
						<td>${emp.lastName }</td>
						<td>${emp.email }</td>
						<td>${emp.gender==0?"Female":"Male" }</td>
						<td>${emp.department.departmentName }</td>
						<td><a href="${pageContext.request.contextPath }/emp/${emp.id }">更新</a></td>
						<td><a class="delete" href="${pageContext.request.contextPath }/emp/${emp.id }">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</center>
	</c:if>
	
	<a href="${pageContext.request.contextPath }/emp">添加</a>
</body>
</html>