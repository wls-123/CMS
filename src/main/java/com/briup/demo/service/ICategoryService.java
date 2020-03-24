package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.utils.CustomerException;

/**
 * 栏目相关的Service层
 * @author wls123
 *
 */
public interface ICategoryService {
	/**
	 * 查询所有栏目
	 */
	List<Category> findAllCategorys() throws  CustomerException;
	
	/**
	 * 添加或修改栏目信息
	 */
	void saveOrUpdateCategory(Category category) throws CustomerException;
	
	/**
	 * 根据id删除栏目信息
	 */
	void deleteCategoryById(short id) throws  CustomerException;
	
	/**
	 * 根据id查找指定的栏目信息
	 */
	Category findCategoryById(short id) throws CustomerException;
	
	/**
	 * 查询栏目信息并且级联查询包含的文章信息
	 */
	List<CategoryEx> findAllCategoryEx() throws CustomerException;
	
	/**
	 * 查询栏目及其包含的文章的所有数据
	 */
	CategoryEx findCategoryExById(short id) throws CustomerException;
}












