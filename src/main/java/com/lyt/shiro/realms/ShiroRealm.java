package com.lyt.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("[FirstRealm] doGetAuthenticationInfo");
		System.out.println("登录之后调用这个方法--doGetAuthenticationInfo:" + token.hashCode() + ", 字符串：" + token.toString());
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.从 UsernamePasswordToken 中获取username
		String username = upToken.getUsername();
		//3.与数据库对比。调用数据库的方法，从数据库中查询username 对应的用户记录
		System.out.println("从数据库中获取 username: " + username + " 所对应的用户信息.");
		//4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
		if("unknown".equals(username)){
			throw new UnknownAccountException("用户不存在!");
		}
		//5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常. 
		if("monster".equals(username)){
			throw new LockedAccountException("用户被锁定");
		}
		//6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		//以下信息是从数据库中获取的.
		//1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象. 
		Object principal = username;
		//2). credentials: 密码. 
		Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4"; //"fc1709d0a95a6be30bc5926fdb7f22f4";
		//3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = ShiroRealm.class.getName();
		//4). 盐值. 
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}
	
	public static void main(String[] args) {
		//在spring的配置文件中有定义：id="jdbcRealm"
		String hashedCredentials = "MD5";//加密算法
		Object credentials = "123456";//读取前台的明文密码
		//盐值加密（比如不同用户，数据库加密后的密码相同，这就需要盐值加密了）
		Object salt = ByteSource.Util.bytes("user");// admin和user
		int hashInterations = 1024;//加密次数
		Object result = new SimpleHash(hashedCredentials, credentials, salt, hashInterations);
		System.out.println("加密1024次后的密码：" + result);
	}
}
