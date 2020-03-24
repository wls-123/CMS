package com.briup.demo.service;


import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerException;

/**
 * 关于链接的相关操作
 * @author wls123
 *
 */
public interface ILinkService {
	/**
	 * 保存或修改链接信息
	 * @param link
	 */
	void saveOrUpdateLink(Link link) throws CustomerException;
	
	/**
	 * 查询所有连接信息
	 * @param id
	 */
	List<Link> findAllLinks() throws CustomerException;
	
	/**
	 * 根据id删除对应链接
	 * @param id
	 */
	void deleteLinkById(short id) throws CustomerException;
	
	/**
	 * 根据 链接名 查询链接
	 */
	List<Link> findByLinksByName(String name) throws CustomerException;
}
