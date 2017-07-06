<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="${pageContext.request.contextPath }/testI18N">Test I18N</a>


	<!-- 切换语言 -->
	<a href="testI18N?locale=zh_CN">中文</a> | <br><br>
	<a href="testI18N?locale=en_US">英语</a>

</body>
</html>