<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:message key="i18n.user" >
		<fmt:param value="zhangsan"></fmt:param>
	</fmt:message>

	<a href="${pageContext.request.contextPath }/testI18N2">Test I18N2</a>
<br><br>
	<!-- 切换语言 -->
	<a href="testI18N?locale=zh_CN">中文</a> | <a href="testI18N?locale=en_US">英语</a>
	

</body>
</html>