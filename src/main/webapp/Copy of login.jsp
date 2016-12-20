<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<h4>登录页面...</h4>
	<script type="text/javascript">
		function login(){
		var a = $("#checkBoxId").attr("checked",'');
		var b = $("#checkBoxId").attr("checked",true);//打勾 
		alert("a = " + a + ",b=" +b)
		}
	</script>
	<form action="shiro/login" method="POST" id="form1">
		<input type="hidden" name="rememberme" id="id" value=""> 
		用户名: <input type="text" name="username" /> <br>
		<br> 密码: <input type="password" name="password" /> <br>
		<br> 记住我：<input type="checkbox" name="checkboxName" id="checkBoxId"> <br>
		<br> 
		<input type="button" value="提交1" onclick="login();" /> 
				<input type="submit" value="提交2"/>
	</form>

</body>
</html>