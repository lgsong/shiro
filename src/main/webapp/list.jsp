<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h4>List Page：列表页面</h4>
	
	欢迎: <shiro:principal></shiro:principal> 进来！
	
	<shiro:hasRole name="admin">
		<br><br>
		<a href="admin.jsp">Admin Page--管理员界面</a>
	</shiro:hasRole>
	
	<shiro:hasRole name="user">
	<br><br>
	<a href="user.jsp">User Page--用户界面</a>
	</shiro:hasRole>
	
	<br><br>
	<a href="shiro/testShiroAnnotation">Test ShiroAnnotation</a>
	
	<br><br>
	<a href="shiro/logout">Logout：登出</a>
	
</body>
</html>