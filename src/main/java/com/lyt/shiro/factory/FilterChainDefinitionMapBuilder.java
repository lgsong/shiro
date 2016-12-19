package com.lyt.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		//在 ShiroHandler中  token.setRememberMe(true);//这个是记住用户，当用户登出之后才会取消
		map.put("/user.jsp", "authc,roles[user]");//认证之后，还有user权限
		map.put("/admin.jsp", "authc,roles[admin]");//认证之后，还要有amdin权限
		map.put("/list.jsp", "user");//这个是只要通过（记住我登陆的--subject.isRemembered()）就可以方法
		
		map.put("/**", "authc");
		
		return map;
	}
	
}
