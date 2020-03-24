package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.Link;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description = "栏目相关接口")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/addCategory")
	@ApiOperation("新增栏目")
	public Message<Category> saveCategory(Category category){
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.Error(StatusCodeUtil.ERROR_CODE, "系统错误"+e.getMessage());
		}
	}
	
	@PostMapping("/updateCategory")
	@ApiOperation("修改栏目")
	public Message<String> updateLink(Category category){
		categoryService.saveOrUpdateCategory(category);
		return MessageUtil.success();
	}
	
	@GetMapping("/getAllCategorys")
	@ApiOperation("查询所有栏目")
	public Message<List<Category>> findAllCategorys(){
		List<Category> list = categoryService.findAllCategorys();
		return MessageUtil.success(list);
	}
	
	@GetMapping("/selectCategorysById")
	@ApiOperation("根据栏目编号查询")
	public Message<Category> findCategoryById(short id){
		Category category = categoryService.findCategoryById(id);
		return MessageUtil.success(category);
	}
	
	@GetMapping("/deleteCategoryById")
	@ApiOperation("根据栏目编号删除栏目")
	public Message<String> deleteCategory(short id){
			categoryService.deleteCategoryById(id);
			return MessageUtil.success();
	}
	
	/**
	 * 根据id查找栏目及其包含的所有文章信息
	 */
	@GetMapping("/findCategoryExById")
	@ApiOperation("根据id查找栏目及其包含的所有文章信息")
	public Message<CategoryEx> findCategoryExById(short id){
		
		return MessageUtil.success(
				categoryService.findCategoryExById(id));
		
	}

}
