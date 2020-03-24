package com.briup.demo.mapper.login;

import com.briup.demo.bean.login.Login;

/**
 * 登入和注册的Mapper接口
 * @author wls123
 *
 */
public interface LoginMapper {

	void register(Login login);
	
	Login login(Login login);
}
