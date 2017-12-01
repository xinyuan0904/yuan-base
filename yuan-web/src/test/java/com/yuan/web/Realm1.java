package com.yuan.web;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class Realm1 implements Realm{

	@Override
	public String getName() {
		return "Realm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		//仅支持UsernamePasswordToken类型的Token
//		return token instanceof UsernamePasswordToken;
		return true;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String uname = (String) token.getPrincipal();
		String pwd = String.valueOf((char[])token.getCredentials());
		System.out.println("uname:"+uname+"pwd:"+pwd);
		if( !"zhang".equals(uname)){
			throw new UnknownAccountException();
		} 
		if( !"123".equals(pwd)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(uname,pwd,getName());
	}

}
