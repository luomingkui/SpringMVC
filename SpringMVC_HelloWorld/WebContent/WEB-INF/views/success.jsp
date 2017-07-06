<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	SpringMVC 你好 !!!!
	<br><br>

	time : ${requestScope.time } <br><br>
	names : ${requestScope.names } <br><br>
	user - request : ${requestScope.user } <br><br>
	school - request : ${requestScope.school } <br><br>
	user - session : ${sessionScope.user } <br><br>
	school - session : ${sessionScope.school } <br><br>
 </body>
</html>