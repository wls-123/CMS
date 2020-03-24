package com.briup.demo.mapper.ex;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;

/**
 * 处理查询栏目及其包含的文章信息
 * @author wls123
 *
 */
public interface CategoryExMapper {
	/**
	 * 实现查询所有栏目及其包含的文章信息
	 * @return
	 */
	List<CategoryEx> findAllCategoryEx();
	
	/**
	 * 查询通过所id查询对应栏目及其包含的文章信息
	 */
	CategoryEx findCategoryExById(short id);
}
