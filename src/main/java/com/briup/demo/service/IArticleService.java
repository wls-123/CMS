package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CustomerException;

/**
 * 文章相关内容的service接口
 * @author wls123
 *
 */
public interface IArticleService {
	/**
	 * 新增或修改文章
	 */
	void saveOrUpdateArticle(Article article) throws CustomerException;
	
	/**
	 * 删除文章
	 */
	void deleteArticleById(short id) throws CustomerException; 
	
	/**
	 * 查询文章
	 * @param keyStr 表示搜索框
	 */
	List<Article> findArticleByCondition(String keyStr,String condition) throws CustomerException;
	
	/**
	 * 根据id查询
	 */
	Article findArticleById(short id) throws CustomerException;
}
