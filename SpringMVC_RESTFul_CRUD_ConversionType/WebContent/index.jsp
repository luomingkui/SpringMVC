<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$("#testJSON").click(function(){
			
			var url = this.href;
			var data = {};
			var callback = function(result){
				/*
				[
				{"id":1001,"lastName":"E-AA","email":"aa@163.com","gender":1,"department":{"id":101,"departmentName":"D-AA"},"birthDay":null,"salary":0.0},
				{"id":1003,"lastName":"E-CC","email":"cc@163.com","gender":0,"department":{"id":103,"departmentName":"D-CC"},"birthDay":null,"salary":0.0},
				{"id":1002,"lastName":"E-BB","email":"bb@163.com","gender":1,"department":{"id":102,"departmentName":"D-BB"},"birthDay":null,"salary":0.0},
				{"id":1005,"lastName":"E-EE","email":"ee@163.com","gender":1,"department":{"id":105,"departmentName":"D-EE"},"birthDay":null,"salary":0.0},
				{"id":1004,"lastName":"E-DD","email":"dd@163.com","gender":0,"department":{"id":104,"departmentName":"D-DD"},"birthDay":null,"salary":0.0}
				]
				*/
				for(var i=0;i<result.length;i++){
					alert(result[i].id+" - " + result[i].lastName);
				}
				
			};
			
			$.post(url,data,callback);
			
			return false ;
		});
		
	});
	
</script>

</head>
<body>

	<a href="${pageContext.request.contextPath }/emps">Query All Employees</a>

	<br><br>

	<a id="testJSON" href="${pageContext.request.contextPath }/testJSON">Test JSON</a>

	<hr>
	
	<form action="${pageContext.request.contextPath }/testHttpMessageConverter" method="post" enctype="multipart/form-data">
		文件: <input type="file" name="file"/><br><br>
		描述: <input type="text" name="desc"/><br><br>
		<input type="submit" value="提交"/>
	</form>
	<hr>
	
	<%-- <a id="testJSON" href="${pageContext.request.contextPath }/responseEntity">Test ResponseEntity</a> --%>

</body>
</html>