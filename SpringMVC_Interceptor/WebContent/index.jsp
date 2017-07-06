<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		文件上传表单要求：
			必须method="post"
			必须enctype="multipart/form-data"
			必须type="file"
	 -->
	<form action="${pageContext.request.contextPath }/testUpload" method="post" enctype="multipart/form-data">
		文件: <input type="file" name="file"/><br><br>
		描述: <input type="text" name="desc"/><br><br>
		<input type="submit" value="上传"/>
	</form>
			
			
	<a href="${pageContext.request.contextPath }/testABC">ABC</a>

</body>
</html>