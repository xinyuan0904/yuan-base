package com.yuan.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class LoginTest {

	@Test
	public void testLogin(){
		//1、获取SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils 
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			subject.login(token);
		}catch(UnknownAccountException e){
			System.out.println("账号不存在");
		}catch(IncorrectCredentialsException e){
			System.out.println("账号/密码错误");
		}catch (AuthenticationException e) {
			System.out.println("登录失败");
			e.printStackTrace();
		}
		
//		System.out.println(subject.getPrincipals().asList());
		System.out.println("是否登录："+subject.isAuthenticated());
		System.out.println(subject.hasRole("role12"));
//		subject.logout();
	}
}
