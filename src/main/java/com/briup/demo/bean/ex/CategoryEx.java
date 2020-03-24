package com.briup.demo.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Article;

import io.swagger.annotations.ApiParam;

/**
 * 栏目的扩展类。
 * 	出了栏目信息，还会级联保存栏目的对应的所有文章信息
 * @author wls123
 *
 */
public class CategoryEx implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Short id;

	@ApiParam(value = "栏目的名称", required = true)
	private String name;

	@ApiParam(value = "栏目的编号", required = true)
	private Short code;
	
	//添加级联的所有文章
	private List<Article> articles;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public CategoryEx(Short id, String name, Short code, List<Article> articles) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.articles = articles;
	}

	public CategoryEx() {
		super();
	}
	
	
}
