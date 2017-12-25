package com.yuan.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * 登录controller
 * @ClassName LoginController
 * @author YUAN
 * @date 2017年12月15日
 * @version 1.0
 */
@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("toLogin")
	@ResponseBody
	public String toLogin(HttpServletRequest request,
			String username, String password){
		JSONObject jo = new JSONObject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		// 记录该令牌
		token.setRememberMe(true);
		// subject权限对象
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.isAuthenticated());
		String exceptionClassName = (String) request
				.getAttribute("shiroLoginFailure");
		//判断是否已登录
		if (subject.isAuthenticated()){
			subject.logout();
		}
		try {
			// 提交申请，验证能不能通过，也回调reaml里的doGetAuthenticationInfo验证是否通过
			subject.login(token);
			System.out.println(exceptionClassName);
		} catch (UnknownAccountException ex) {// 用户名没有找到
			jo.put("msg", "用户未找到");
//			ex.printStackTrace();
		} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
			jo.put("msg", "密码不正确");
//			map.put("msg", "密码不正确");
//			ex.printStackTrace();
		} catch (AuthenticationException e) {// 其他的登录错误
			jo.put("msg", "其他错误");
//			e.printStackTrace();
		} catch (Exception e) {
			jo.put("msg", "登录异常");
//			e.printStackTrace();
		}
		
		// 验证是否成功登录的方法
		if (subject.isAuthenticated()) {
			jo.put("msg", "登录成功");
		}else{
			jo.put("msg", "登录失败");
		}
		return jo.toJSONString();
	}
	
	@RequestMapping("/logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
}
