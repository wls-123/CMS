package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.login.Login;
import com.briup.demo.service.ILoginService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import ch.qos.logback.core.status.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "登入/注册")
public class LoginController {
	@Autowired
	private ILoginService loginService;
	
	@PostMapping("/register")
	@ApiOperation("注册")
	public Message<String> register(Login login){
		try {
			loginService.register(login);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.Error(StatusCodeUtil.ERROR_CODE, "参数为空"+e.getMessage());
		}
		
	} 
}
