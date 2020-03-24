package com.briup.demo.service;

import com.briup.demo.bean.login.Login;
import com.briup.demo.utils.CustomerException;

/**
 * 登录与注册
 * @author wls123
 *
 */
public interface ILoginService {
	/**
	 * 登入操作
	 */
	Login login(Login login) throws CustomerException;
	
	/**
	 * 注册操作
	 */
	void register(Login login) throws CustomerException;
}
