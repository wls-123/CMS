package com.briup.demo.bean.login;

import java.io.Serializable;

import io.swagger.annotations.ApiParam;

public class Login implements Serializable{
	private short id;
	/**
	 * 用户名
	 */
	@ApiParam(value = "用户名", required = true)
	private String username;
	
	/**
	 * 密码
	 */
	@ApiParam(value = "用户名密码", required = true)
	private String password;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(short id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Login() {
		super();
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	
	
	
	
}
