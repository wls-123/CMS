package com.briup.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.login.Login;
import com.briup.demo.service.ILoginService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private ILoginService loginService;

	
	@Override
	public Login login(Login login) throws CustomerException {
		return login;
		
	}

	@Override
	public void register(Login login) throws CustomerException {
		if(login.getPassword() == null || login.getPassword().trim()=="") {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "密码不能为空");
		}else {
			System.out.println(login);
			//return;
			loginService.register(login);
		}
			
		
	}

}
