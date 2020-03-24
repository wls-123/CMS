package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 操作栏目的Service功能类
 * @author wls123
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired 
	private ArticleMapper articleMapper;
	
	//栏目的拓展dao
	@Autowired
	private CategoryExMapper categoryExMapper;
	
	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		// 参数为引用类型，要判空处理
		if (category == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		if (category.getId() == null) {
			categoryMapper.insert(category);
		} else {
			categoryMapper.updateByPrimaryKey(category);
		}
	}

	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		CategoryExample example = new CategoryExample();
		List<Category> list = categoryMapper.selectByExample(example);
		return list;
	}


	@Override
	public void deleteCategoryById(short id) throws CustomerException {
		//删除栏目时要先删除文章信息
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryIdEqualTo(id);
		articleMapper.deleteByExample(example);
		
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category findCategoryById(short id) throws CustomerException {
		Category category = categoryMapper.selectByPrimaryKey(id);
		return category;
	}

	@Override
	public List<CategoryEx> findAllCategoryEx() throws CustomerException {
		List<CategoryEx> list = categoryExMapper.findAllCategoryEx();
		return list;
	}

	@Override
	public CategoryEx findCategoryExById(short id) throws CustomerException {
		CategoryEx findCategoryExById = categoryExMapper.findCategoryExById(id);
		return findCategoryExById;
	}
	
	
}
