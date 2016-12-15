<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h4>登录页面...</h4>
	
	<form action="shiro/login" method="POST">
		用户名: <input type="text" name="username"/>
		<br><br>
		
		密码: <input type="password" name="password"/>
		<br><br>
		
		<input type="submit" value="提交"/>
	</form>
	
</body>
</html>