<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>1.映射请求路径：</h2>
	<!-- 实验1 ：HelloWorld -->
	<a href="${pageContext.request.contextPath }/springmvc/helloworld">第一个SpringMVC的HelloWorld</a>

	<br><br>

	<!-- 实验2 ：@RequestMapping 修饰类和修饰方法-->
	<a href="${pageContext.request.contextPath }/springmvc/testRequestMapping">Test RequestMapping</a>

	<br><br>

	<!-- 实验3 ：测试请求参数与请求头 -->
	<a href="${pageContext.request.contextPath }/springmvc/testRequestParamsAndHeads?username=zhangsan&age=15">Test RequestParamsAndHeads</a>
	
	<br><br>

	<!-- 实验4：测试Ant风格路径 -->
	<a href="${pageContext.request.contextPath }/springmvc/user/aaa/path">Test AntPath</a><br>
	<a href="${pageContext.request.contextPath }/springmvc/user/aaa/bbb/path">Test AntPath</a>
	
	<br><br>
	
	<!-- 实验5 ：测试映射URL的占位符 -->
	<a href="${pageContext.request.contextPath }/springmvc/testPathVariable/18">Test PathVariable</a>
	
	<br><br>
	
	
	
	
	<hr>
	<h2>2.REST风格 - GET/POST/PUT/DELETE：</h2>
	<br><br>
	
	<!-- 实验6：测试REST风格  GET请求 -->
	<a href="${pageContext.request.contextPath }/springmvc/testRESTGet/1">Test REST Get</a>
	
	<br><br>
	
	<!-- 实验7：测试REST风格  POST请求 -->
	<form action="${pageContext.request.contextPath }/springmvc/testRESTPost" method="POST">
		<input type="submit" value="添加"/>
	</form>	
	
	<br><br>
	
	<!-- 实验8：测试REST风格  PUT请求 -->
	<form action="${pageContext.request.contextPath }/springmvc/testRESTPut/1" method="POST">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="修改"/>
	</form>	
	
	<br><br>
	
	<!-- 实验9：测试REST风格  DELETE请求 -->
	<form action="${pageContext.request.contextPath }/springmvc/testRESTDelete/1" method="POST">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="删除"/>
	</form>
		
	<br><br>

	<hr>
	<h2>3.请求：方法入参</h2>
	<!-- 实验10 ： 测试@RequestParam -->
	<a href="${pageContext.request.contextPath }/springmvc/testRequestParam?username=zhangsan&age=10">Test RequestParam</a>

	<br><br>
	<!-- 实验11： 测试@RequestHeader -->
	<a href="${pageContext.request.contextPath }/springmvc/testRequestHeader">Test RequestHeader</a>

	<br><br>
	<!-- 实验12： 测试@CookieValue -->
	<a href="${pageContext.request.contextPath }/springmvc/testCookieValue">Test CookieValue</a>

	<br><br>
	<!-- 测试13 :  POJO 对象传参，支持级联属性 -->
	<form action="${pageContext.request.contextPath }/springmvc/testPOJO" method="GET">
		username: <input type="text" name="username"/><br>
		password: <input type="password" name="password"/><br>
		email: <input type="text" name="email"/><br>
		age: <input type="text" name="age"/><br>
		city: <input type="text" name="address.city"/><br>
		province: <input type="text" name="address.province"/>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>

	<!-- 测试14： Servlet API 作为处理请求参数 -->
	<a href="${pageContext.request.contextPath}/springmvc/testServletAPI">Test ServletAPI</a>
	<br><br>

	<hr>
	<h2>4.响应：数据传播</h2>
	<!--测试15： ModelAndView 作为处理返回结果 -->
	<a href="${pageContext.request.contextPath }/springmvc/testModelAndView">Test ModelAndView</a>
	<br><br>

	<!-- 测试16：  Map 作为处理返回结果 -->
	<a href="springmvc/testMap">testMap</a>
	<br><br>
	
	<!--测试17:  @SessionAttribute 将数据存放到session域中 -->
	<a href="${pageContext.request.contextPath }/springmvc/testSessionAttributes">Test SessionAttributes</a>
	
	<hr>
	<h2>5.模型驱动</h2>
	
	<!-- 实验18 ： 演示更新操作 -->
	<!-- 
		模拟表单回显，修改页面：
			数据库中的原始数据：(密码：123)
				1-Tom-tom@guigu.com-12
			表单提交时，没有提交password参数，说明password字段值不需要修改的。保证更新时密码不能丢失		
	 -->
	<form action="springmvc/testModelAttribute" method="POST">
		<input type="hidden" name="id" value="1"><br>
		username: <input type="text" name="username" value="Tom"/>
		email: <input type="text" name="email" value="tom@guigu.com"/>
		age: <input type="text" name="age" value="12"/>
		<input type="submit" value="Submit"/>                
	</form>
	
	
	
	


</body>
</html>