package com.briup.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.IArticleService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 实现文章管理相关的逻辑类
 * @author wls123
 *
 */
@Service
public class ArticleServiceImpl implements IArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private CategoryMapper CategoryMapper;
	
	@Override
	public void saveOrUpdateArticle(Article article) throws CustomerException {
		if(article == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		if(article.getId() == null) {
			//需要额外添加两条数据
			article.setPublishdate(new Date());
			article.setClicktimes((short)0);
			articleMapper.insert(article);
		}else {
			article.setPublishdate(new Date());
			articleMapper.updateByPrimaryKey(article);
		}
	}

	@Override
	public void deleteArticleById(short id) throws CustomerException {
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Article> findArticleByCondition(String keyStr, String condition) throws CustomerException {
		/**
		 * 分四种情况：
		 *  1.没有添加任何条件，则查询所有文章;
		 *  2.没有指定栏目，但指定了查询的关键字，则根据关键字查询满足条件的所有文章;
		 *  3.指定栏目。但是没有指定查询关键字，则根据栏目查询其中的所有文章;
		 *  4.指定栏目，同时指定查询的关键字，则根据栏目和关键字查询满足条件的文章。
		 */
		keyStr = keyStr==null?"":keyStr.trim();
		condition = condition==null?"":condition.trim();
		ArticleExample example = new ArticleExample();
		if("".equals(keyStr) && "".equals(condition)) {
			//情况1
			return articleMapper.selectByExample(example);
		}else if(!"".equals(keyStr) && "".equals(condition)) {
			//情况2
			example.createCriteria().andTitleLike("%"+keyStr+"%");
			return articleMapper.selectByExample(example);
		}else if (!"".equals(condition) && "".equals(keyStr)) {
			//情况3
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(condition);
			List<Category> categorie = CategoryMapper.selectByExample(categoryExample);
			if(categorie.size() > 0) {
				
				example.createCriteria().andCategoryIdEqualTo(categorie.get(0).getId());
			}else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE,"没有指定的搜索栏目");
			}
			return articleMapper.selectByExample(example);
		}else {
			//情况4
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(condition);
			List<Category> categorie = CategoryMapper.selectByExample(categoryExample);
			
			example.createCriteria().andCategoryIdEqualTo(categorie.get(0).getId()).andTitleLike("%"+keyStr+"%");
			return articleMapper.selectByExample(example);
			
		}
	}

	@Override
	public Article findArticleById(short id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		Short clicktimes = article.getClicktimes();
		article.setClicktimes(++clicktimes);
		
		this.saveOrUpdateArticle(article);
		return article;
	}

}
